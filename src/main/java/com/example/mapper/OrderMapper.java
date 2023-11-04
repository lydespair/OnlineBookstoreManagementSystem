package com.example.mapper;

import com.example.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> selectOrder(Integer orderId);

    @Select("select * from `order` where order_id = #{orderId}")
    Order selectOrderById(Integer orderId);

    @Insert("insert into `order` (user_id, create_time, price)" +
            "values (#{userId}, #{createTime}, #{price})")
    @Options(useGeneratedKeys = true, keyColumn = "order_id", keyProperty = "orderId")
    void insert(Order order);

    @Select("select * from `order` where user_id = #{userId}")
    List<Order> selectAll(Integer userId);
}
