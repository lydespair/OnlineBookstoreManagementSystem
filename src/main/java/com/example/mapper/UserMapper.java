package com.example.mapper;

import com.example.pojo.Order;
import com.example.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    

    //    查询全部用户
    List<User> list(String key, Integer type);

    void deleteById(List<Integer> ids);

    @Insert("insert into user (user_name, user_password, address, tel, email, image) " +
            "values (#{userName}, #{userPassword}, #{address}, #{tel}, #{email}, #{image})")
    void insert(User user);

    @Select("select * from user where user_name = #{name}")
    User getByName(String name);

    @Update("update user " +
            "set user_name = #{userName}, user_password = #{userPassword}, user.address = #{address}, " +
            "user.tel = #{tel}, user.email = #{email}, image = #{image}, state = #{state} where user_id = #{userId}")
    void update(User user);

    @Select("select * from user where user_name = #{userName} and user_password = #{userPassword}")
    User getByUsernameAndPassword(User user);

    @Insert("insert into user (user_name, user_password)" +
            "values (#{userName}, #{userPassword})")
    void register(User user);

    @Select("select * from user where user_id = #{userId}")
    User selectUserById(Integer userId);

    @Select("select count(*) from user")
    Integer selectAll();

    @Select("select * from user where user_id = #{userId}")
    User findByUserId(Integer userId);
}
