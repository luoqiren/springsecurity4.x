<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ page isELIgnored="false"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>  
<head>  
    <meta http-equiv="Content-Type" content="text/html; UTF-8">  
    <title>Login page</title>  
</head>  
<body>  
    <div id="mainWrapper">  
        <div  >  
            <div  >  
                <div >  
                    <c:url var="loginUrl" value="/login" />  
                    <form action="${loginUrl}" method="post" class="form-horizontal">  
                        <c:if test="${param.error != null}">  
                            <div  >  
                                <p>Invalid username and password.</p>  
                            </div>  
                        </c:if>  
                        <c:if test="${param.logout != null}">  
                            <div  >  
                                <p>You have been logged out successfully.</p>  
                            </div>  
                        </c:if>  
                        <div >  
                            <label for="username"><i ></i></label>  
                            <input type="text" id="username" name="ssoId" placeholder="Enter Username" required>  
                        </div>  
                        <div >  
                            <label  for="password"><i></i></label>   
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>  
                        </div>  
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />  
                               
                        <div >  
                            <input type="submit"  
                                  value="Log in">  
                        </div>  
                    </form>  
                </div>  
            </div>  
        </div>  
    </div>  

</body>  
</html>  