Create table Users (
	id varchar(10) primary key,
	name varchar(30) not null
);
insert into Users value ('1', 'Gominseok');
insert into Users value ('tim4974', 'Hanjongmin');
insert into Users value ('tjralsrh', 'GoMinSeok');
insert into Users value ('Danmuzi', 'LeeJaeHoon');

Select * from Users where id = 'tim4974';
update Users set name = '고민석' where id = '1';
delete from Users where id = '1';


