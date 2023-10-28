package com.example.service;

import com.example.pojo.Order;
import com.example.utils.PageBean;
import com.example.pojo.User;

import java.util.List;


public interface UserService {

//    查询全部用户
    PageBean list(Integer page, Integer pageSize, String key, Integer type);

    void delete(List<Integer> ids);

    void add(User user);

    User getByName(String name);

    void update(User user);

    User login(User user);

    void register(User user);

    List<Order> cart(Integer state);

    void pay(Order order);

    void addCart(Order order);
}
