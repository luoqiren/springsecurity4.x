spring security起步五：Remember Me功能实现 

Remember-Me是指网站能够在Session之间记住登录用户的身份，具
体来说就是我成功认证一次之后在一定的时间内我可以不用再输入用户名和密码进行登录了，系统会自动给我登录。
这通常是通过服务端发送一个cookie给客户端浏览器，下次浏览器再访问服务端时服务端能够自动检测客户端的cookie，根据cookie值触发自动登录操作。

关注点:
remember-me属性详解
remember-me属性是spring security命名空间中实现自动登录的专属配置项,它有如下属性
1. key：这个”key”属性用来辨别分辨不同项目的cookie
2. authentication-success-handler-ref 指向一个AuthenticationSuccessHandler
3. data-source-ref 指向一个DataSource数据源
4. remember-me-cookie：cookie存放的名称.默认为’remember-me’.
5. remember-me-parameter：触发自动登录的请求参数名称.默认为’remember-me’.
6. services-alias：声明一个内部定义的RememberMeServices的bean的别名,提供给程序的其他bean使用
7. services-ref：指向一个RememberMeServices,可以自定义实现自己的自动登录逻辑
8. token-repository-ref：指向一个PersistentTokenRepository bean,用来实现持久化令牌的自动登录
9. token-validity-seconds：cookie存在的时间周期,单位为秒
10. use-secure-cookie：是否设置”secure”标志,具体使用不详
11. user-service-ref：指向一个UserDetailsService的bean


。