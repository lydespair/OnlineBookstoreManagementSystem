package com.example.mapper;

import com.example.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {

    @Insert("insert into orderdetail (order_id, ISBN, book_count)" +
            " VALUES (#{orderId}, #{ISBN}, #{bookCount})")
    void insert(OrderDetail orderDetail);

    @Select("select * from orderdetail where order_id = #{orderId}")
    List<OrderDetail> selectByOrderId(Integer orderId);
}
