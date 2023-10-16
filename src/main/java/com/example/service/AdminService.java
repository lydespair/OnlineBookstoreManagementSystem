package com.example.service;

import com.example.pojo.Admin;
import com.example.pojo.Order;

import java.util.List;

public interface AdminService {
    List<Order> selectOrder(Order order);

    Admin login(Admin user);
}
