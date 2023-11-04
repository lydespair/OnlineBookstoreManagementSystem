package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private Integer orderDetailId;
    private Integer orderId;
    private String ISBN;
    private Integer bookCount;
}
