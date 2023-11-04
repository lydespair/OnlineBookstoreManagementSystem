package com.example.service;

import com.example.pojo.Cart;
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

    List<Cart> cart(Integer userId);

    void pay(Order order);

    Integer counts();

    void addCart(Integer userId, String ISBN, Integer count);

    void deleteCart(List<Integer> list);

    User findByUserId(Integer userId);
}
