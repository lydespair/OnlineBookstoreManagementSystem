package com.example.service.impl;

import com.example.mapper.BookMapper;
import com.example.pojo.Book;
import com.example.utils.PageBean;
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

        List<Book> bookList = bookMapper.listBySales();
        Page<Book> p = (Page<Book>) bookList;

        return new PageBean(p.getTotal(), p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        bookMapper.delete(ids);
    }

    @Override
    public List<Book> recommend() {
        return bookMapper.recommend();
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public Book getByISBN(String ISBN) {
        return bookMapper.getByISBN(ISBN);
    }

    @Override
    public Integer counts() {
        return bookMapper.counts();
    }

    @Override
    public void add(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public Book findByIsbn(String ISBN) {
        return bookMapper.selectByISBN(ISBN);
    }
}
