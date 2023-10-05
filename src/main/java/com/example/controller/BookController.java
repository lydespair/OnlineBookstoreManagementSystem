package com.example.controller;

import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize, Integer type, String name) {
        PageBean pageBean = bookService.page(page, pageSize, type, name);
        return Result.success(pageBean);
    }
}
