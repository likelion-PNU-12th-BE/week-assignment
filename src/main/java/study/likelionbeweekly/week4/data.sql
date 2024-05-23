-- docker run -it mysql /bin/bash
-- mysql -u root -p
-- show databases;
-- create database likeliondb;
-- show databases;
-- use likeliondb;
create table Users (
    id varchar(10) primary key,
    name varchar(10) not null
);
-- show tables;
insert into Users (id,name) values ('1', 'hello');
select * from Users;
insert into Users (id,name) values ('1', 'hello');
select * from Users where id='1';
select * from Users where id='2';
update Users
set id='2'
where id='1';
select * from Users where id='2';
delete from Users where id='2';
select * from Users;