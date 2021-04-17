package com.luosu.blog.mapper;

import com.luosu.blog.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> getAllUser();
    public List<User> findByEmail(String email);
}
