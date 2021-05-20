package com.luosu.blog.service;

import com.luosu.blog.entity.User;
import com.luosu.blog.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private static ApplicationContext context;
    private static UserMapper userMapper;
    //为了初始化
    static {
        context = new ClassPathXmlApplicationContext("spring-dao.xml");
        userMapper = context.getBean("userMapper", UserMapper.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username, String pwd) {
        return null;
    }

    @Override
    public UserDetails loadUserByEmail(String email, String pwd) {
        List<User> users = userMapper.findByEmail(email);
        User loginedUser = null;
        for (User usr: users) {
            if (usr.getPwd().equals(pwd)) {
                loginedUser = usr;
                break;
            }
        }
        if(loginedUser == null) return null;
        System.out.printf("username: %s", loginedUser.getName());
       org.springframework.security.core.userdetails.User loginedUserDetails = new org.springframework.security.core.userdetails.User(loginedUser.getName(),
                loginedUser.getPwd(),
        true, false,
        false, false,
        null);
        return loginedUserDetails;
    }
}
