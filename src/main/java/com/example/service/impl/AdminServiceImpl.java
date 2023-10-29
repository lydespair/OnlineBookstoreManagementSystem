package com.example.service.impl;

import com.example.mapper.AdminMapper;
import com.example.mapper.BookMapper;
import com.example.mapper.OrderMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Admin;
import com.example.pojo.Book;
import com.example.pojo.Order;
import com.example.pojo.User;
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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Order> selectOrder(Integer orderId) {
        return orderMapper.selectOrder(orderId);
    }

    @Override
    public Admin login(Admin root) {
        return adminMapper.login(root);
    }

    @Override
    public Order findByOrderId(Integer orderId) {
        return orderMapper.selectOrderById(orderId);
    }

    @Override
    public User findByUserId(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public Book findByISBN(String isbn) {
        return bookMapper.selectByISBN(isbn);
    }

}
