package com.example.controller;

import com.example.pojo.Order;
import com.example.pojo.OrderDetail;
import com.example.service.OrderService;
import com.example.utils.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping
    public Result add(@RequestBody Order order) {
        log.info("data: {}", order);
        orderService.add(order);
        log.info("{}", order.getOrderId());
        return Result.success(order.getOrderId());
    }

    @GetMapping("/all")
    public Result all(@RequestParam Integer userId) {
        log.info("queryAll !");
        List<Order> orderList = orderService.all(userId);
        return Result.success(orderList);
    }

    @PostMapping("/detail")
    public Result insert(@RequestBody OrderDetail orderDetail) {
        log.info("订单详情: {}", orderDetail);
        orderService.insert(orderDetail);
        return Result.success();
    }

    @GetMapping("/detail")
    public Result queryByOrderId(@RequestParam Integer orderId) {
        log.info("根据orderId查询订单详情： {}", orderId);
        List<OrderDetail> orderDetailList = orderService.queryByOrderId(orderId);
        return Result.success(orderDetailList);
    }
}
