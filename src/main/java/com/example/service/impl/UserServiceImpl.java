package com.example.service.impl;

import com.example.mapper.OrderMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Order;
import com.example.utils.PageBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String key, Integer type) {
        PageHelper.startPage(page, pageSize);

        List<User> userList = userMapper.list(key, type);
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
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public List<Order> cart(Integer state) {
        return orderMapper.cart(state);
    }

    @Override
    public void pay(Order order) {
        order.setState((short) 0);
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        orderMapper.add(order);
    }

    @Override
    public void addCart(Order order) {
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        order.setState((short) 1);
        orderMapper.addCart(order);
    }

    @Override
    public Integer counts() {
        return userMapper.selectAll();
    }
}
