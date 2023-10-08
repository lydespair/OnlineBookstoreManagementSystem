package com.example.service;

import com.example.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> cart(Integer state);
}
