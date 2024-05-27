use likelion;
set sql_safe_updates = 0;

create table if not exists users (
    id varchar(10) primary key,
    name varchar(10) not null
);

insert into users(id, name)
values('1', 'minseokgo');

select * from users;

select *
from users
where id = '1';

update users
set name = 'minseokko'
where id = '1';

delete from users where id = '1';

select * from users;