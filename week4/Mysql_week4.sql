-- cli로 database 생성하는 법
-- C:\Program Files\MySQL\MySQL Server 8.0\bin>mysqld start
-- C:\Program Files\MySQL\MySQL Server 8.0\bin>mysql -u root -p
-- 해당 경로에서 다음 명령어 실행

-- database 생성 및 사용(일종의 폴더 열기)
-- create database likelion;
-- use likelion;

create database mydata;
use mydata;

create table users(
id Varchar(10) primary key,
name varchar(10) not null
);

select id, name from user;
drop table user;
select id, name from user;

Insert INTO users(id, name) values('1', 'seongbin');
-- 명시를 안하면 다 작성해야함
-- 명시를 하면 필요한 내용만 작성하면 됨
Insert INTO users(id, name) values('2', 'a');
Insert INTO users(id, name) values('3', 'b');
Insert INTO users(id, name) values('4', 'c');

select id, name from users;
-- from where select 순으로 읽힘

select id, name from users where id = '1';

update users set name = 'likeanlion' where id = '2';
select id, name from users;

delete from users where id ='4';
select * from users;
-- *는 전부라는 의미

select id as 아이디, name as 이름 from users ;

-- DROP table table명 || database database명 삭제
drop database mydatabase;
drop table mydata.user;
drop database aaaaa;