-- 查看默认事务隔离级别
select @@tx_isolation;

--    设置事务隔离级别               脏读          不可重复读           幻读
-- 读未提交 read-uncommitted         是             是                是
-- 读已提交 read-committed           否             是                是
-- 可重复读 repeateble-red           否             否                是
-- 串行化 serializable               否             否                否
set session transaction isolation level read uncommitted;

-- 脏读 (事务B读未回滚，事务A读并回滚)
-- 事务A
begin;
select * from imooc_user where id=1;
rollback;

-- 事务B
begin;
update imooc_user set age=20 where id=1;
rollback;

-- 不可重复读
-- 事务A
begin ;
select * from imooc_user where id = 1;
select * from imooc_user where id = 1;
rollback;

-- 事务B
begin ;
update imooc_user set age=0 where id=1;
commit ;

-- 建表

drop database if exists os;
create database os;
use os;
drop table if exists orders;

drop table if exists products;

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   id                   char(6) not null,
   products_id          char(6) not null,
   number               int,
   price                double,
   create_time          datetime,
   send_time            datetime,
   confirm_time         datetime,
   consignee            varchar(20),
   consignee_phone      char(11),
   consignee_address    varchar(100),
   status               varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Table: products                                              */
/*==============================================================*/
create table products
(
   id                   char(6) not null,
   title                varchar(20),
   price                double,
   stock                int,
   status               varchar(10),
   primary key (id)
);

alter table orders add constraint FK_Reference_1 foreign key (products_id)
      references products (id) on delete restrict on update restrict;

insert into products values('100001','小米8',2699,100,'正常');
insert into products values('100002','小米8SE',1799,100,'正常');
insert into products values('100003','小米MIX2S',3299,100,'正常');
insert into products values('100004','小米手环3',199,100,'正常');


