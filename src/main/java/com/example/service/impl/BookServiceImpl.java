package com.example.service.impl;

import com.example.mapper.BookMapper;
import com.example.pojo.Book;
import com.example.pojo.PageBean;
import com.example.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//
//        long count = bookMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Book> bookList = bookMapper.page(start, pageSize);
//
//        PageBean pageBean = new PageBean(count, bookList);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, Integer type, String name) {

        PageHelper.startPage(page, pageSize);

        List<Book> bookList = bookMapper.list(type, name);
        Page<Book> p = (Page<Book>) bookList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public PageBean rank(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        List<Book> bookList = bookMapper.listBySale();
        Page<Book> p = (Page<Book>) bookList;

        return new PageBean(p.getTotal(), p.getResult());
    }
}
