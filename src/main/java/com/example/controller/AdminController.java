package com.example.controller;


import com.example.pojo.Admin;
import com.example.pojo.Order;
import com.example.service.AdminService;
import com.example.utils.JwtUtils;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    可根据用户id和订单id查询
    @GetMapping
    public Result selectOrder(@RequestBody Order order) {
        List<Order> orderList = adminService.selectOrder(order);
        return Result.success(orderList);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Admin root) {
        log.info("管理员登录: {}", root);
        Admin r = adminService.login(root);
        if (r != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", r.getAdminId());
            claims.put("name", r.getAdminName());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
