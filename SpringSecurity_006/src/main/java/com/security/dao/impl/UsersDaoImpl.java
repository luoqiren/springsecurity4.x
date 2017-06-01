package com.security.dao.impl;


import org.springframework.stereotype.Repository;

import com.security.dao.UsersDao;
import com.security.model.Users;

@Repository
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {
	
	@Override
	public Users getUsers(String userName) {
		return (Users) this.load(Users.class, userName);
	}

}
