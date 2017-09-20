package com.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.MyUsersDao;
import com.security.model.MyUsers;
import com.security.service.MyUsersService;

@Service
@Transactional
public class MyUsersServiceImpl implements MyUsersService {

	@Autowired
	@Qualifier(value="myUsersDaoImpl")
	private MyUsersDao myUsersDao;
	
	@Override
	public MyUsers getUsers(String userName) {
		return myUsersDao.getMyUsers(userName);
	}

}
