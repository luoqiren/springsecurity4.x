package com.security.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="t_users")
public class MyUsers implements UserDetails, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//spring security 默认段
	private String userName;
	private String password;
	private String enabled;
	//自定义扩展段
	private String realName;
	private Integer age;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	@Id
	@Column(name="username")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="enabled")
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Column(name="realname")
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public boolean isAccountNonExpired() {//default true, 未过期
		return true;
	}
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public boolean isAccountNonLocked() {//default true, 没被锁住
		return true;
	}
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {//default true, 证件未过期
		return true;
	}
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public boolean isEnabled() {
		return "1".equals(this.enabled);
	}
	//声明了非持久化属性，即数据库中没有相应的映射字段，是一个普通属性
	@Transient
	@Override
	public String getUsername() {
		return this.userName;
	}
}
