package com.example.mapper;

import com.example.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> list(Integer type, String name);

    @Select("select * from book order by count desc")
    List<Book> listBySale();

    void delete(List<Integer> ids);
}
