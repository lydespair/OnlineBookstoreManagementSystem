package com.example.controller;

import com.example.pojo.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result list() {
        log.info("查询全部的用户数据");

        List<User> list = userService.list();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除用户:{}", id);
        userService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        log.info("新增用户：{}", user);
        userService.add(user);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById (@PathVariable Integer id) {
        log.info("根据id查找用户:{}", id);
        User user = userService.getById(id);
        return Result.success(user);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("修改用户:{}", user);
        userService.update(user);
        return Result.success();
    }
}
