package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private String bookId;
    private Integer userId;
    private int count;
    private float price;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private short state;
}
