package com.example.mapper;

import com.example.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Insert("insert into cart (user_id, ISBN, count) values (#{userId}, #{ISBN}, #{count})")
    void insert(Integer userId, String ISBN, Integer count);

    @Select("select * from cart where user_id = #{userId}")
    List<Cart> select(Integer userId);

    void deleteCart(List<Integer> list);
}
