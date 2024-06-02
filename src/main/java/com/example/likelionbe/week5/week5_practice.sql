CREATE TABLE `Member` (
                            `id`	int	NOT NULL,
                            `age`	int	NULL,
                            `name`	varchar(20)	NOT NULL
);

CREATE TABLE `Post` (
                             `id`	int	NOT NULL,
                             `content`	varchar(200)	NOT NULL,
                             `img`	varchar(200)	NULL,
                             `like`	int	NULL,
                             `id2`	int	NOT NULL	COMMENT 'user외래키'
);

CREATE TABLE `Comment` (
                             `id`	int	NOT NULL,
                             `name`	varchar(20)	NOT NULL,
                             `date`	date	NOT NULL,
                             `content`	varchar(200)	NOT NULL,
                             `id2`	int	NOT NULL
);

ALTER TABLE `Member` ADD CONSTRAINT `PK_UNTITLED` PRIMARY KEY (
                                                                 `id`
    );

ALTER TABLE `Post` ADD CONSTRAINT `PK_UNTITLED2` PRIMARY KEY (
                                                                   `id`
    );

ALTER TABLE `Comment` ADD CONSTRAINT `PK_UNTITLED3` PRIMARY KEY (
                                                                   `id`
    );

Alter table Post add foreign key(id2) references Member(id) on delete cascade;
Alter table Comment add foreign key(id2) references Post(id) on delete cascade;

--Member에 추가하기
insert into Member(id, age, name) values (1,25,'im');
--Post에 추가하기
insert into Post(id, content, id2) values (1,'소개글입니다', 1);
--Comment에 값 추가하기
insert into Comment (id, name, "date", content, id2)values (1, 'im',now(),'좋습니당',1);
--inner join으로 content내용 찾아오기
select content from Member join Post on Post.id2 = Member.id;
--left join으로 댓글 내용 찾기
select Comment.content from Member left join Comment on Comment.id2 = Member.id;
--right join으로 댓글 쓴사람과 번화 찾기
select Comment.id , Member.name from Member RIGHT JOIN Comment on Comment.id2 = Member.id;
--full join하기
select Member.name , Comment.content from Member left join Comment on Member.id = Comment.id2
     union
select Member.name, Comment.content from Member right join Comment on Member.id = Comment.id2;
--update
update Member set age = 26 where id =1;
--delete
delete from Member where id = 1;