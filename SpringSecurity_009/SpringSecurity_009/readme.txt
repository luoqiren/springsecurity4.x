重写认证方式， 即表名不再是 user authorities

Spring security中的系统的User只有username,password,enabled等几个属性
 
 CREATE TABLE `t_users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` int(1) NOT NULL,
  `realname` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
--admin  admin
INSERT INTO `t_users` VALUES ('admin', '$2a$10$5rqXIC/dwDfbFyHVwviUAuOAMrzvbXXNWpZzGwXq9lKcCumwToIWm', 1, '阿德敏', 23);
INSERT INTO `t_users` VALUES ('guest', 'guest', 1, '格斯忒', 18);
 
 CREATE TABLE `t_authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `t_ix_auth_username` (`username`,`authority`),
  CONSTRAINT `t_fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `t_users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
INSERT INTO `t_authorities` VALUES ('admin', 'ROLE_USER');
 --------------
 1.实现实体类， 扩展字段， 其中
 	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	} 重要
 2.重写用户验证程序， MyUserDetailsServiceImpl 实现 UserDetailsService， 主要实现UserDetails loadUserByUsername(String username)方法
 3.LoginController 获取详细报错信息， 可以写在日志， 也可以返回前端
 4.login.jsp logout.jsp 的form表单传输方式均为POST
 
 
 