package com.luosu.blog;

import com.luosu.blog.entity.User;
import com.luosu.blog.entity.UserAddr;
import com.luosu.blog.mapper.UserAddrMapper;
import com.luosu.blog.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class BlogApplicationTests {

	@Test
	void contextLoads() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserAddrMapper uaaddrMapper = context.getBean("userAddrMapper", UserAddrMapper.class);
		for(UserAddr addr : uaaddrMapper.getAllUserAddr()){
			System.out.println(addr);
		}
	}

	@Test
	void testUser(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		for(User user : userMapper.getAllUser()){
			System.out.println(user);
		}
	}

	@Test
	void testFindByEmail(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
		for(User user : userMapper.findByEmail("2@aluosu.com")){
			System.out.println(user);
		}
	}
}
