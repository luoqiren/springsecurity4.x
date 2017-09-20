package com.security.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.dao.MyUsersDao;
import com.security.model.MyUsers;

public class MyUserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired  
	private JdbcTemplate jdbcTemplate; 
	@Autowired
	private MyUsersDao myUsersDao;
    private final String sqlLoadUser;  
    private final String sqlLoadAuthorities;  
    private final RowMapper<MyUsers> myUserDetailsRowMapper;  
    private final RowMapper<GrantedAuthority> authorityRowMapper;
    
    
	public MyUserDetailsServiceImpl() {
		super();  
		sqlLoadUser = "SELECT username, password, enabled from t_users  WHERE username=?";
		sqlLoadAuthorities = "SELECT authority FROM t_authorities WHERE username=?";
		
		myUserDetailsRowMapper = new RowMapper<MyUsers>(){
			@Override
			public MyUsers mapRow(ResultSet rs, int rowNum) throws SQLException {
				MyUsers myUsers= new MyUsers();
				myUsers.setUserName(rs.getString(1));
				myUsers.setPassword(rs.getString(2));
				myUsers.setEnabled(rs.getString(3));
				return myUsers;
			}
		};
		authorityRowMapper = new RowMapper<GrantedAuthority>() {
			@Override
			public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new SimpleGrantedAuthority(rs.getString(1));
			}
			
		};
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUsers returnObj = null;
		try{
			MyUsers userFromQuery = jdbcTemplate.queryForObject(sqlLoadUser, myUserDetailsRowMapper, username);
			System.out.println("查询得到用户：{}"+ userFromQuery.getUsername());
			List<GrantedAuthority> authorities =  jdbcTemplate.query(sqlLoadAuthorities, authorityRowMapper, username);
			System.out.println("得到其权限：{}"+ authorities.size());
			returnObj = myUsersDao.getMyUsers(username);//获取完整的用户对象
			returnObj.setAuthorities(authorities);//权限不可或缺
			System.out.println(returnObj.getRealName()+"_age:"+returnObj.getAge());
			
			if(authorities.size()==0){
				System.out.println("该用户无任何权限:"+ username);
				throw new BadCredentialsException("该用户无任何权限:"+ username);
			}
			
		}catch(EmptyResultDataAccessException e){
			System.out.println("无该用户:"+ username);
			throw new UsernameNotFoundException("用户名或密码不正确");
		}
		return returnObj;
	}
	
	
	

}
