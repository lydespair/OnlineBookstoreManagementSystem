package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.User;

import java.util.List;


public interface UserService {

//    查询全部用户
    PageBean list(Integer page, Integer pageSize, String name);

    void delete(List<Integer> ids);

    void add(User user);

    User getById(Integer id);

    void update(User user);

    User login(User user);
}
