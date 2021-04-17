package com.luosu.blog.service;

import com.luosu.blog.entity.User;
import com.luosu.blog.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserService {

    private static ApplicationContext context;
    private static UserMapper userMapper;
    //为了初始化
    static {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");
        userMapper = context.getBean("userMapper", UserMapper.class);
    }

    //用email登陆
    public static User loginByEmail(String email, String pwd){
        List<User> users = userMapper.findByEmail(email);
        User loginedUser = null;
        for (User usr: users) {
            System.out.println(usr.getPwd());
            if(usr.getPwd() == pwd){
                loginedUser = usr;
                break;
            }
        }
        System.out.println(pwd);
        System.out.println(users);
        return loginedUser;
    }
}
