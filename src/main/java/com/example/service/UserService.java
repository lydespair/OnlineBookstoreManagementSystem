package com.example.service;

import com.example.pojo.User;

import java.util.List;

public interface UserService {

//    查询全部用户
    List<User> list();

    void delete(Integer id);

    void add(User user);

    User getById(Integer id);

    void update(User user);
}
