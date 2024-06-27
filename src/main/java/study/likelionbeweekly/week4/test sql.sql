select * from users; -- 테이블 조회
SELECT * FROM likeliondb.users;

insert into `likeliondb`.`users`(`id`, `name`) values ("im", "eunhye");
insert into `likeliondb`.`users`(`id`, `name`) values ("go", "minseok");

select * from likeliondb.users;

select * from likeliondb.users where(id="go"); -- 엔티티 조회

update `likeliondb`.`users` set `id` = "Go" where (`id` = "go");

select * from likeliondb.users;

delete from `likeliondb`.`users` where(`id` = "Go");

select * from likeliondb.users;