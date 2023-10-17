package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private BigInteger userId;
    private String userName;
    private String userPassword;
    private String address;
    private String tel;
    private String email;
    private String image;
}
