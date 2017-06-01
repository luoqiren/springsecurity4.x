spring security起步三：自定义登录配置与form-login属性详解 

在上一篇 spring security起步二：自定义登录页中我们实现了如何自定义登录页,但是还存在很多问题：
1.spring security如何对登录请求进行拦截
2.登录成功后如何跳转
3.登录失败后如何跳转

form-login属性详解
form-login是spring security命名空间配置登录相关信息的标签,它包含如下属性：
1. login-page 自定义登录页url,默认为/login   ===>UsernamePasswordAuthenticationFilter 这里默认是  /login
2. login-processing-url 登录请求拦截的url,也就是form表单提交时指定的action
3. default-target-url 默认登录成功后跳转的url
4. always-use-default-target 是否总是使用默认的登录成功后跳转url
5. authentication-failure-url 登录失败后跳转的url
6. username-parameter 用户名的请求字段 默认为userName
7. password-parameter 密码的请求字段 默认为password
8. authentication-success-handler-ref 指向一个AuthenticationSuccessHandler用于处理认证成功的请求,
	不能和default-target-url还有always-use-default-target同时使用
9. authentication-success-forward-url 用于authentication-failure-handler-ref
10. authentication-failure-handler-ref 指向一个AuthenticationFailureHandler用于处理失败的认证请求
11. authentication-failure-forward-url 用于authentication-failure-handler-ref
12. authentication-details-source-ref 指向一个AuthenticationDetailsSource,在认证过滤器中使用

spring security登录相关的过滤器

首先应注意的一点是,spring security 3.x 默认的登录拦截URL是/j_spring_security_check,
而spring security 4.x默认拦截的URL是/login。

在spring security中,具体处理表单登录验证的是o.s.s.w.a.UsernamePasswordAuthenticationFilter,
另外一个过滤器o.s.s.w.a.ui.DefaultLoginPageGeneratingFilter用于在没有指定登录页时动态生成一个默认登录页





