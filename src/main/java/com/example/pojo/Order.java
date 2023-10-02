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
    private Integer bookId;
    private Integer userId;
    private int count;
    private float price;
    private short userCheck;
    private LocalDateTime postTime;
    private short adminCheck;
}
