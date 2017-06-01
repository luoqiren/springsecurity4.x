<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
<style>  
.error {  
    padding: 15px;  
    margin-bottom: 20px;  
    border: 1px solid transparent;  
    border-radius: 4px;  
    color: #a94442;  
    background-color: #f2dede;  
    border-color: #ebccd1;  
}  
  
.msg {  
    padding: 15px;  
    margin-bottom: 20px;  
    border: 1px solid transparent;  
    border-radius: 4px;  
    color: #31708f;  
    background-color: #d9edf7;  
    border-color: #bce8f1;  
}  
  
#login-box {  
    width: 300px;  
    padding: 20px;  
    margin: 100px auto;  
    background: #fff;  
    -webkit-border-radius: 2px;  
    -moz-border-radius: 2px;  
    border: 1px solid #000;  
}  
</style>  
</head>  
<body onload='document.loginForm.username.focus();'>  
    <div id="login-box">  
        <h3>Login with Username and Password中文  s7</h3> 
        <form name="loginForm" action="${pageContext.request.contextPath }/loginPage/" method="POST">  
        	<security:csrfInput />
            <table>  
                <tr>  
                    <td>用户:</td>  
                    <td><input type='text' name='username' value=''></td>  
                </tr>  
                <tr>  
                    <td>密码:</td>  
                    <td><input type='password' name='password' /></td>  
                </tr>  
                <tr>
				    <td colspan='2'>
				        <input id="remember-me" name="remember-me" type="checkbox" checked="checked"/>自动登录
				    </td>
				</tr>
                <tr>  
                    <td colspan='2'><input name="submit" type="submit" value="登录" /></td>  
                </tr>  
            </table>  
        </form>  
    </div>  
</body>  
</html> 