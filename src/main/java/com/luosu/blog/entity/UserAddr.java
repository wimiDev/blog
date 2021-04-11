package com.luosu.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddr {
    private int id;
    private int userid;
    private String phone;
    private String addr;
    private String consignee;
}
