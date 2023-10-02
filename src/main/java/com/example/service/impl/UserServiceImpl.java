package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.PageBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public PageBean list(Integer page, Integer pageSize, String name) {
        PageHelper.startPage(page, pageSize);

        List<User> userList = userMapper.list(name);
        Page<User> p = (Page<User>) userList;
        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public void add(User user) {
        user.setUserPassword("999");
        user.setTel("11301000323");
        user.setAddress("江苏南京");
        userMapper.insert(user);
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
