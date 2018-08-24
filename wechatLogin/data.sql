use imooc;

create table user(
id int primary key auto_increment,
openid varchar(50),
unionid varchar(50),
s_key varchar(50),
session_key varchar(50),
nick_name varchar(50),
gender varchar(50),
country varchar(50),
province varchar(50),
city varchar(50),
avatar_url varchar(200)
);