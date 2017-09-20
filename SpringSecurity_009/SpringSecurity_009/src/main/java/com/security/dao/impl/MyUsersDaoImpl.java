package com.security.dao.impl;


import org.springframework.stereotype.Repository;

import com.security.dao.MyUsersDao;
import com.security.model.MyUsers;

@Repository
public class MyUsersDaoImpl extends BaseDaoImpl implements MyUsersDao {
	
	
	public MyUsersDaoImpl() {
	}

	@Override
	public MyUsers getMyUsers(String userName) {
		return (MyUsers) this.load(MyUsers.class, userName);
	}

}
