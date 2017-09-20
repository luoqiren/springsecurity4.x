package com.security.dao;

import com.security.model.MyUsers;

public interface MyUsersDao extends BaseDao {
	
	MyUsers getMyUsers(String userName);
	
}
