package com.example.mapper;

import com.example.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> list(Integer type, String name);

    @Select("select * from book order by sales desc")
    List<Book> listBySales();

    void delete(List<Integer> ids);

    @Select("select * from book order by sales desc limit 5")
    List<Book> recommend();

    @Update("update book" +
            " set book_name = #{bookName}, type = #{type}, publisher = #{publisher}," +
            " price = #{price}, author = #{author}, publish_date = #{publishDate}, " +
            "count = #{count}, image = #{image}, `describe` = #{describe} where ISBN = #{ISBN}")
    void update(Book book);

    @Select("select * from book where ISBN = #{ISBN}")
    Book getByISBN(String ISBN);

    @Select("select count(*) from book")
    Integer counts();

    @Insert("insert into book (isbn, book_name, type, publisher," +
            " price, author, publish_date, count, image, `describe`) " +
            "values (#{ISBN}, #{bookName}, #{type}, #{publisher}, #{price}," +
            " #{author}, #{publishDate}, #{count}, #{image}, #{describe})")
    void insert(Book book);

    @Select("select * from book where ISBN = #{isbn}")
    Book selectByISBN(String isbn);
}
