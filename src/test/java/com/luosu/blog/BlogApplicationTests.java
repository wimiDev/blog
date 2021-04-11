package com.luosu.blog;

import com.luosu.blog.entity.UserAddr;
import com.luosu.blog.mapper.UserAddrMapper;
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

}
