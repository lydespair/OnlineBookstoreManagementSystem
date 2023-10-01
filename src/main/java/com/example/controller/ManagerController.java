package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Result list() {
        log.info("查询全部的用户数据");

        List<User> list = userService.list();
        return Result.success(list);
    }

    @DeleteMapping("/users/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除用户:{}", id);
        userService.delete(id);
        return Result.success();
    }
}
