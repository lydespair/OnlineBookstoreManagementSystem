package com.example.service;

import com.example.utils.PageBean;

import java.util.List;

public interface BookService {

    PageBean page(Integer page, Integer pageSize, Integer type, String name);

    PageBean rank(Integer page, Integer pageSize);

    void delete(List<Integer> ids);
}
