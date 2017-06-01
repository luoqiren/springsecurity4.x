package com.security.dao;

import com.security.model.Users;

public interface UsersDao extends BaseDao {
	
	Users getUsers(String userName);
	
}
