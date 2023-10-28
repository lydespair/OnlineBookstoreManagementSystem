package com.example.service;

import com.example.pojo.Admin;
import com.example.pojo.Order;

import java.util.List;

public interface AdminService {
    List<Order> selectOrder(Integer orderId);

    Admin login(Admin user);
}
