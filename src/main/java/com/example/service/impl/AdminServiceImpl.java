package com.example.service.impl;

import com.example.mapper.AdminMapper;
import com.example.mapper.OrderMapper;
import com.example.pojo.Admin;
import com.example.pojo.Order;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Order> selectOrder(Integer orderId) {
        return orderMapper.selectOrder(orderId);
    }

    @Override
    public Admin login(Admin root) {
        return adminMapper.login(root);
    }

}
