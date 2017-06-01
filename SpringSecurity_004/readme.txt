 spring security起步四：退出登录配置以及logout属性详解 
 
关注点：
用户退出登录实质是使当前登录用户的session失效的操作。
一般来说,用户退出后,将会被重定向到站点的非安全保护页,比如登录页面。

主要技术关注点 spring security退出功能相关类:
spring security实现注销功能涉及的三个核心类为LogoutFilter,LogoutHandler,LogoutSuccessHandler
LoginFilter是实现注销功能的过滤器,默认拦截/logout或者logout属性logout-url指定的url

LogoutHandler接口 定义了退出登录操作的方法
void logout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication);
            
LogoutSuccessHandler接口 定义了注销之后的操作方法
void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException;            
            
具体请查看
\src\main\resources\logout 结构图.png

spring security退出功能实现流程

spring security在实现注销功能时,大致流程如下
1. 使得HTTP session失效(如果invalidate-session属性被设置为true);
2. 清除SecurityContex(真正使得用户退出)
3. 将页面重定向至logout-success-url指明的URL

-------------------------------------------------------------------------------
logout 属性详解

1. logout-url LogoutFilter 要读取的url,也就是指定spring security拦截的注销url
2. logout-success-url 用户退出后要被重定向的url
3. invalidate-session 默认为true,用户在退出后Http session失效
4. success-handler-ref 对一个LogoutSuccessHandler的引用,用来自定义退出成功后的操作

这里需要注意的一点是,spring security 3.x默认的注销拦截url为/j_spring_security_logout,
而4.x则默认使用/logout




