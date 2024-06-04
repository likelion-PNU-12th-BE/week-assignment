CREATE TABLE `Member` (
	`User_id`	bigint	NOT NULL    AUTO_INCREMENT PRIMARY KEY,
	`nick`	varchar(20)	NOT NULL,
	`email`	varchar(30)	NOT NULL,
	`password`	varchar(20)	NOT NULL,
	`JoinDate`	DATETIME	NOT NULL
); -- 테이블 생성

CREATE TABLE `Post` (
    `Post_id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Title` varchar(30) NOT NULL,
    `Content` text NOT NULL,
    `User_id` bigint NOT NULL,
    `CreatedDate` DATETIME NOT NULL,
    FOREIGN KEY (`User_id`) REFERENCES `Member`(`User_id`)
); -- 테이블 생성

CREATE TABLE `Comment` (
    `Comment_id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Post_id` bigint NOT NULL,
    `User_id` bigint NOT NULL,membermember
    `Content` text NOT NULL,
    `CreatedDate` DATETIME NOT NULL,
    FOREIGN KEY (`Post_id`) REFERENCES `Post`(`Post_id`),
    FOREIGN KEY (`User_id`) REFERENCES `Member`(`User_id`)
); -- 테이블 생성

INSERT INTO Member (nick, email, password, JoinDate)
VALUES
('A', 'AAA@google.com', 'google', NOW()),
('B', 'BBB@naver.com', 'naver', NOW()),
('C', 'CCC@daum.net', 'daum', NOW()); -- 값 입력

insert into  post (Title, Content, User_id, createddate)
values
('first post', 'this is A first post', 1, now()),
('second post', 'this is B second post', 2, now()),
('third post', 'this is third post', 3, now()); -- 값 입력

insert into Comment(post_id, user_id, content, createddate)
values
(1, 2, 'this is comment from B to A', now()),
(2, 1, 'this is comment from A to B', now()),
(3, 1, 'this is comment from A to third post', now()),
(3, 2, 'this is comment from B to third post', now()); -- 값 입력

select * from member; -- 테이블 조회
select * from post; -- 테이블 조회
select * from comment; -- 테이블 조회

-- inner join
select member.nick, post.title, comment.content
from member
inner join post on member.user_id = post.user_id
inner join comment on post.post_id = comment.post_id;

-- left join
select member.nick, Post.Title
from Member
left join Post on Member.user_id = Post.user_id

-- right join
select post.title, member.nick
from post
right join member on member.user_id = post.user_id

-- full join mysql에서 full join 지원하지 않기 때문에 union 사용
select member.user_id, post.title
from member
left join post on member.user_id = post.user_id
union
select member.user_id, post.title
from post
right join member on member.user_id = post.user_id;


