package com.example.service;

import com.example.pojo.PageBean;
import com.example.pojo.User;


public interface UserService {

//    查询全部用户
    PageBean list(Integer page, Integer pageSize, String name);

    void delete(Integer id);

    void add(User user);

    User getById(Integer id);

    void update(User user);

}
