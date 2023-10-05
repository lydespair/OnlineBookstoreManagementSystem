package com.example.service;

import com.example.pojo.PageBean;

public interface BookService {

    PageBean page(Integer page, Integer pageSize, Integer type, String name);

    PageBean rank(Integer page, Integer pageSize);
}
