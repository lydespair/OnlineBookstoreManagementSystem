package com.example.service.impl;

import com.example.mapper.OrderMapper;
import com.example.pojo.Order;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements AdminService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectOrder(Order order) {
        return orderMapper.selectOrder(order);
    }
}
