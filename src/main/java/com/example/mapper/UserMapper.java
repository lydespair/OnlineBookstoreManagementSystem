package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

//    查询全部用户
    @Select("select * from user")
    List<User> list();

    @Delete("delete from user where user_id = #{id}")
    void deleteById(Integer id);
}
