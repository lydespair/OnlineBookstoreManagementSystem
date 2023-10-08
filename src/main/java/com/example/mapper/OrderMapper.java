package com.example.mapper;

import com.example.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from `order` where state = #{state}" )
    List<Order> cart(Integer state);
}
