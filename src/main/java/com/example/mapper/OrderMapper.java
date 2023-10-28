package com.example.mapper;

import com.example.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("select * from `order` where state = #{state}" )
    List<Order> cart(Integer state);

    @Insert("insert into `order` " +
            "(user_id, ISBN, count, price, create_time, update_time, state) " +
            "values (#{userId}, #{bookId}, #{count}, #{price}, #{createTime}, #{updateTime}, #{state})")
    void add(Order order);

    @Insert("insert into `order` " +
            "(user_id, ISBN, count, price, create_time, update_time, state) " +
            "values (#{userId}, #{bookId}, #{count}, #{price}, #{createTime}, #{updateTime}, #{state})")
    void addCart(Order order);

    List<Order> selectOrder(Integer orderId);
}
