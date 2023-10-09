package com.example.controller;

import com.example.pojo.User;
import com.example.utils.Result;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@Slf4j
@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        log.info("用户注册");
        if (userService.getByName(user.getUserName()) != null) return Result.error("用户名重复");
        if (Objects.equals(user.getUserName(), "") || user.getUserName() == null
                || Objects.equals(user.getUserPassword(), "") || user.getUserPassword() == null)
            return Result.error("非法输入");
        userService.register(user);
        return Result.success();
    }
}
