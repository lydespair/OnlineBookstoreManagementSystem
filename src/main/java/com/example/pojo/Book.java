package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;
    private short type;
    private String ISBW;
    private String publisher;
    private float price;
    private String author;
    private LocalDate publishDate;
    private int count;
    private byte[] image;
    private String describe;
}
