package com.example.controller;


import com.example.pojo.Order;
import com.example.service.AdminService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private AdminService adminService;

//    可根据用户id和订单id查询
    @GetMapping
    public Result selectOrder(@RequestBody Order order) {
        List<Order> orderList = adminService.selectOrder(order);
        return Result.success(orderList);
    }
}
