package com.example.controller;

import com.example.pojo.Order;
import com.example.utils.PageBean;
import com.example.utils.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam(defaultValue = "") String name) {
        log.info("查询全部的用户数据");

        PageBean pageBean = userService.list(page, pageSize, name);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除, ids: {}", ids);
        userService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody User user) {
        log.info("新增用户：{}", user);
        userService.add(user);
        return Result.success();
    }

    @GetMapping("/{name}")
    public Result getByName(@PathVariable String name) {
        log.info("根据name查找用户:{}", name);
        User user = userService.getByName(name);
        return Result.success(user);
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("修改用户:{}", user);
        userService.update(user);
        return Result.success();
    }

    //查询订单 {
//      state: 0 -> 已支付
//             1 -> 待付款
//    }
    @GetMapping("/cart")
    public Result cart(Integer state) {
        List<Order> orderList = userService.cart(state);
        return Result.success(orderList);
    }

    //加入购物车
    @PostMapping("/addCart")
    public Result addCart(@RequestBody Order order) {
        userService.addCart(order);
        return Result.success();
    }

    @PostMapping("/pay")
    public Result pay(@RequestBody Order order) {
        userService.pay(order);
        return Result.success();
    }
}
