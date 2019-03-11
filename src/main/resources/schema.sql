/*
用户表
 */
create table FX_USER(
  USER_ID integer not null primary key auto_increment,
  USER_NAME varchar(50) not null,
  USER_PASSWORD varchar(100) not null
);
/*
通过用户名登录，用户名设置成唯一，相当于用户账户
 */
ALTER TABLE `fx_user` ADD UNIQUE( `USER_NAME`);


/*
角色表
 */
create table FX_ROLE(
    ROLE_ID integer not null primary key,
    ROLE_NAME varchar(50) not null
);
/*
角色名唯一约束
 */
ALTER TABLE `fx_role` ADD UNIQUE( `ROLE_NAME`);


/*
角色用户映射表
 */
create table FX_USER_ROLE(
    USER_ID integer not null,
    ROLE_ID integer not null,
    foreign key(USER_ID) references fx_user(USER_ID),
    foreign key(ROLE_ID) references fx_role(ROLE_ID),
    primary key(USER_ID,ROLE_ID)
);