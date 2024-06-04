create database likelion;

show databases;

use likelion;

drop table if exists Users;

create table Users(
	id       varchar(10) primary key,
    username varchar(10) not null
);

show tables;

desc Users;

insert into Users(id, username)
values('yuem', 'ahyeon');

select id from Users;
select * from Users;

update Users
set username = 'mmmm'
where id = 'yuem';

delete from Users where id = 'yuem';