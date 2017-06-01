package com.lqr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.security.service.UsersService;

public class MyTest {

	private ApplicationContext context = null;
	private UsersService usersService = null;
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		usersService = context.getBean(UsersService.class);
	}

	@Test
	public void test1() {
//		UsersDao usersDao = new UsersDaoImpl();
		System.out.println(usersService.toString());
		System.out.println(usersService.getUsers("guest").getPassword());
	}

}
