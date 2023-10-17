package com.example.controller;

import com.example.pojo.Book;
import com.example.utils.PageBean;
import com.example.utils.Result;
import com.example.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/ranks")
    public Result rank(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize) {
        PageBean pageBean = bookService.rank(page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {

        bookService.delete(ids);
        return Result.success();
    }


    @GetMapping("/{ISBN}")
    public Result getByISBN(@PathVariable String ISBN) {
        log.info("根据ISBN查找图书:{}", ISBN);
        Book book = bookService.getByISBN(ISBN);
        return Result.success(book);
    }
    @PutMapping
    public Result update(@RequestBody Book book) {
        log.info("修改图书信息");
        bookService.update(book);
        return Result.success();
    }
}
