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
    public void delete(List<Integer> ids) {
        userMapper.deleteById(ids);
    }

    @Override
    public void add(User user) {
        user.setTel("11301000323");
        user.setAddress("上海");
        userMapper.insert(user);
    }

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }

    @Override
    public void register(String name, String password) {
        userMapper.register(name, password);
    }
}
