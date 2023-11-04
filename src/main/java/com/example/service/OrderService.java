package com.example.service;

import com.example.pojo.Order;
import com.example.pojo.OrderDetail;

import java.util.List;

public interface OrderService {

    List<Order> all(Integer userId);

    void insert(OrderDetail orderDetail);

    void add(Order order);

    List<OrderDetail> queryByOrderId(Integer orderId);
}
