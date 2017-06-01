package com.security.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.dao.UsersDao;
import com.security.model.Users;
import com.security.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	@Qualifier(value="usersDaoImpl")
	private UsersDao usersDao;
	
	@Override
	public Users getUsers(String userName) {
		return usersDao.getUsers(userName);
	}

}
