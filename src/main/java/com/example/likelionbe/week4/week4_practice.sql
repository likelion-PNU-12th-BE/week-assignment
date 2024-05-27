create table User
(
    id   VARCHAR(10) PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);

insert into User (id, name) values ('junsikim','junsik');
insert into User (id, name) values ('minseokgo','minseok');

select id name from User where id = 'minseokgo';

update User set id = '임준식', name = '준식' where id = 'junsikim';
delete from user where id = '임준식';
select * from User;