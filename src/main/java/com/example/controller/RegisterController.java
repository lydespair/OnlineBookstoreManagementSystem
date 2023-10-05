package com.example.controller;

import com.example.pojo.Result;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result Register(String name, String password) {
        log.info("用户注册");
        if (userService.getByName(name) != null) return Result.error("用户名重复");
        userService.register(name, password);
        return Result.success();
    }
}
