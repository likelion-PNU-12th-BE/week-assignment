drop table if exists Member;
drop table if exists Post;
drop table if exists Comment;


create TABLE `Member` (
	`id`	BIGINT	NOT NULL,
	`name`	VARCHAR(10)	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `Post` (
	`id`	BIGINT	NOT NULL,
	`title`	VARCHAR(50)	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`member_id`	VARCHAR(500)	NOT NULL
);

CREATE TABLE `Comment` (
	`id`	BIGINT	NOT NULL,
	`content`	VARCHAR(100)	NOT NULL,
	`create_time`	DATETIME	NOT NULL,
	`update_time`	DATETIME	NOT NULL,
	`member_id`	VARCHAR(500)	NOT NULL,
	`post_id`	VARCHAR(500)	NOT NULL
);

alter TABLE `Member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`id`
);

ALTER TABLE `Post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
	`id`
);

ALTER TABLE `Comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`id`
);

ALTER TABLE `Post` ADD CONSTRAINT `FK_Member_TO_Post_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `Member` (
	`id`
);

ALTER TABLE `Comment` ADD CONSTRAINT `FK_Member_TO_Comment_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `Member` (
	`id`
);

ALTER TABLE `Comment` ADD CONSTRAINT `FK_Post_TO_Comment_1` FOREIGN KEY (
	`post_id`
)
REFERENCES `Post` (
	`id`
);

INSERT INTO Member (id, name, email)
VALUES (1, 'dodo', 'dodo01@gmail.com'),
	   (2, 'bobo', 'bobo01@gmail.com');

INSERT INTO Member
VALUES (3, 'popo', 'popo01@gmail.com'); /* 컬럼명 생략하고 삽입 */
       
SELECT * FROM Member; /* 조건 없이 Member table의 모든 데이터를 조회 */
       

/* inner join */
SELECT * FROM Member INNER JOIN Comment ON Member.id = Comment.id;

/* left join */
SELECT Member.id, Post.title, Comment.content
FROM Member
LEFT JOIN Post
ON Member.id = Post.id;

/* right join */
SELECT Member.id, Post.title, Comment.content
FROM Member
RIGHT JOIN Post
ON Member.id = Post.id;

/* right join */
SELECT Member.id, Post.title, Comment.content
FROM Member
RIGHT JOIN Post
ON Member.id = Post.id;

/* full join */
SELECT id
FROM Member
UNION
SELECT id
FROM Comment;
