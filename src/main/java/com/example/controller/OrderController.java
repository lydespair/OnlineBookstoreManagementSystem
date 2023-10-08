package com.example.controller;

import com.example.pojo.Order;
import com.example.service.OrderService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/cart")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{state}")
    public Result cart(@PathVariable Integer state) {
        log.info("购物车查询");
        List<Order> orders = orderService.cart(state);
        return Result.success(orders);
    }
}
