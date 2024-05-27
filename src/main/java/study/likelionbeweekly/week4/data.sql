create database likelion;

show databases;

use likelion;

drop table users;

create table Users(
	id 		 varchar(10) primary key,
    username varchar(10) not null
);

show tables;

desc Users;

insert into Users(id, username)
values('park', 'jueun');

select id from Users;
select * from Users;

update Users set username = 'hmmm' where id = 'park';

delete from Users where id = 'park';