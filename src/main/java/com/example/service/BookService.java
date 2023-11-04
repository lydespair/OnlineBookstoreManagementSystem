package com.example.service;

import com.example.pojo.Book;
import com.example.utils.PageBean;

import java.util.List;

public interface BookService {

    PageBean page(Integer page, Integer pageSize, Integer type, String name);

    PageBean rank(Integer page, Integer pageSize);

    void delete(List<Integer> ids);

    List<Book> recommend();

    void update(Book book);

    Book getByISBN(String ISBN);

    Integer counts();

    void add(Book book);

    Book findByIsbn(String ISBN);
}
