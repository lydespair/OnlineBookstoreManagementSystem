package com.example.controller;

import com.example.pojo.Book;
import com.example.pojo.Cart;
import com.example.pojo.Order;
import com.example.service.BookService;
import com.example.utils.JwtUtils;
import com.example.utils.PageBean;
import com.example.utils.Result;
import com.example.pojo.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "100") Integer pageSize,
                       @RequestParam(defaultValue = "") String key,
                       @RequestParam(defaultValue = "") Integer type) {
        log.info("查询key: {}", type);

        PageBean pageBean = userService.list(page, pageSize, key, type);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除, ids: {}", ids);
        userService.delete(ids);
        return Result.success();
    }

    @GetMapping("/exact")
    public Result findByUserId(@RequestParam Integer userId) {
        User user = userService.findByUserId(userId);
        return Result.success(user);
    }
    @PostMapping
    public Result add(@RequestBody User user) {
        log.info("新增用户：{}", user);
        userService.add(user);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        log.info("修改用户:{}", user);
        userService.update(user);
        return Result.success();
    }

    @GetMapping("/counts")
    public Result counts() {
        Integer count = userService.counts();
        return Result.success(count);
    }

    @GetMapping("/cart")
    public Result cart(@RequestParam(defaultValue = "") Integer userId) {
        List<Cart> cartList = userService.cart(userId);
        return Result.success(cartList);
    }

    //加入购物车
    @GetMapping("/addCart")
    public Result addCart(@RequestParam(defaultValue = "0") Integer userId,
                          @RequestParam(defaultValue = "") String ISBN,
                          @RequestParam(defaultValue = "1") Integer count) {
        log.info("data: {}", userId);
        userService.addCart(userId, ISBN, count);
        return Result.success();
    }

    @PostMapping("/cart")
    public Result deleteCart(@RequestBody List<Integer> list) {
        log.info("删除：{}", list);
        userService.deleteCart(list);
        return Result.success();
    }

    @PostMapping("/pay")
    public Result pay(@RequestBody Order order) {
        userService.pay(order);
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("用户登录: {}", user);
        User u = userService.login(user);
        if (u != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getUserId());
            claims.put("name", u.getUserName());
            claims.put("username", u.getUserName());
            String jwt = JwtUtils.generateJwt(claims);
            log.info("令牌：{}", jwt);
            return Result.success(u, jwt);
        }
        return Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result Register(@RequestBody User user) {
        log.info("用户注册 USER: {}", user);
        if (userService.getByName(user.getUserName()) != null) return Result.error("用户名重复");
        if (Objects.equals(user.getUserName(), "") || user.getUserName() == null
                || Objects.equals(user.getUserPassword(), "") || user.getUserPassword() == null)
            return Result.error("非法输入");
        userService.register(user);
        return Result.success();
    }

    @GetMapping("/recommend")
//    图书推荐功能
    public Result recommend() {
        List<Book> bookList = bookService.recommend();
        return Result.success(bookList);
    }
}
