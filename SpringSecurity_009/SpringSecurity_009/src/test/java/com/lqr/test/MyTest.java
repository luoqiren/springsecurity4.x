package com.lqr.test;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.service.MyUsersService;

public class MyTest {

	private ApplicationContext context = null;
	private MyUsersService usersService = null;
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		usersService = context.getBean(MyUsersService.class);
	}

	@Ignore
	@Test
	public void test1() {
//		UsersDao usersDao = new UsersDaoImpl();
		System.out.println(usersService.toString());
		System.out.println(usersService.getUsers("guest").getPassword());
	}

	@Test
	public void test2(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("admin"));
	}
}
