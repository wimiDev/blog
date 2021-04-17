package com.luosu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String code;
    private String pwd;
    private String name;
    private String phone;
    private String email;
    private String addr;
}
