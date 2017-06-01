spring security起步六：基于数据库的用户认证

配置数据源dataSource


create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

-- 插入两个用户
insert users  VALUES('admin','admin',1);
insert users  VALUES('guest','guest',1);
-- 赋予guest权限ROLE_USER
insert authorities VALUES('admin','ROLE_USER');


<authentication-manager alias="authenticationManager">
    <authentication-provider>
        <jdbc-user-service data-source-ref="dataSource"/>
    </authentication-provider>
</authentication-manager>
通过以上配置,就基本实现了简单的基于数据库的用户认证.原来项目中通过内存保存用户
