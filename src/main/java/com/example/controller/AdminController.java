package com.example.controller;


import com.example.pojo.Admin;
import com.example.pojo.Book;
import com.example.pojo.Order;
import com.example.pojo.User;
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
    public Result selectOrder(@RequestParam(defaultValue = "-1") Integer orderId) {
        log.info("根据key查找：{}", orderId);
        List<Order> orderList = adminService.selectOrder(orderId);
        return Result.success(orderList);
    }

    @GetMapping("/findByOrderId")
    public Result findByOrderId(@RequestParam(defaultValue = "") Integer orderId) {
        log.info("根据orderId查找: {}", orderId);
        Order order = adminService.findByOrderId(orderId);
        return Result.success(order);
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
            return Result.success(r, jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @GetMapping("/findByUserId")
    public Result findByUserId(@RequestParam(defaultValue = "") Integer userId) {
        log.info("根据userId查找: {}", userId);
        User user = adminService.findByUserId(userId);
        return Result.success(user);
    }

    @GetMapping("/findByISBN")
    public Result findByISBN(@RequestParam(defaultValue = "") String isbn) {
        Book book = adminService.findByISBN(isbn);
        return Result.success(book);
    }
}
