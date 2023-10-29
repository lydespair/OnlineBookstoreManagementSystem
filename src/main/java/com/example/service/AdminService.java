package com.example.service;

import com.example.pojo.Admin;
import com.example.pojo.Book;
import com.example.pojo.Order;
import com.example.pojo.User;

import java.util.List;

public interface AdminService {
    List<Order> selectOrder(Integer orderId);

    Admin login(Admin user);

    Order findByOrderId(Integer orderId);

    User findByUserId(Integer userId);

    Book findByISBN(String isbn);
}
