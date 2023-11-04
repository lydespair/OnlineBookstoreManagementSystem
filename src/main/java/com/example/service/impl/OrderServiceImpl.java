package com.example.service.impl;

import com.example.mapper.CartMapper;
import com.example.mapper.OrderDetailMapper;
import com.example.mapper.OrderMapper;
import com.example.pojo.Order;
import com.example.pojo.OrderDetail;
import com.example.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Resource
    private CartMapper cartMapper;

    @Override
    public void add(Order order) {
        order.setCreateTime(LocalDateTime.now());
        orderMapper.insert(order);
    }

    @Override
    public List<OrderDetail> queryByOrderId(Integer orderId) {
        return orderDetailMapper.selectByOrderId(orderId);
    }


    @Override
    public List<Order> all(Integer userId) {
        return orderMapper.selectAll(userId);
    }

    @Override
    public void insert(OrderDetail orderDetail) {
        orderDetailMapper.insert(orderDetail);
    }
}
