CREATE TABLE `member` (
	`id`	BIGINT	NOT NULL,
	`name`	VARCHAR(20)	NOT NULL,
	`email`	VARCHAR(100)	NOT NULL
);

CREATE TABLE `post` (
	`id`	BIGINT	NOT NULL,
	`title`	VARCHAR(100)	NOT NULL,
	`content`	VARCHAR(500)	NOT NULL,
	`member_id`	BIGINT	NOT NULL
);

CREATE TABLE `comment` (
	`id`	BIGINT	NOT NULL,
	`content`	VARCHAR(100)	NOT NULL,
	`member_id`	BIGINT	NOT NULL,
	`post_id`	BIGINT	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`id`
);

ALTER TABLE `post` ADD CONSTRAINT `PK_POST` PRIMARY KEY (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_COMMENT` PRIMARY KEY (
	`id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_member_TO_post_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `member` (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`member_id`
)
REFERENCES `member` (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_post_TO_comment_1` FOREIGN KEY (
	`post_id`
)
REFERENCES `post` (
	`id`
);

-- 데이터 삽입
INSERT INTO member (id, name, email)
VALUES (1, 'Amy', 'Amy@google.com'),
       (2, 'John', 'John@google.com'),
       (3, 'Irene', 'Irene@google.com');

INSERT INTO post (id, title, content, member_id)
VALUES (1, 'A', 'HELLO', 1),
       (2, 'B', 'HI', 2),
       (3, 'C', 'BYE', 3);

INSERT INTO comment (id, content, member_id, post_id)
VALUES (1, 'hello', 1, 1),
       (2, 'hi', 2, 2),
       (3, 'bye', 3, 3);

-- 테이블 조회
SELECT * FROM member;
SELECT * FROM post;
SELECT * FROM comment;

-- 조인으로 조회
-- INNER JOIN
SELECT post.title, comment.content FROM post
INNER JOIN comment ON post.id = comment.post_id;

-- LEFT JOIN
SELECT member.id, post.content FROM member
LEFT JOIN post ON member.id = post.member_id;

-- RIGHT JOIN
SELECT comment.content, member.name FROM comment
RIGHT JOIN member ON member.id = comment.member_id;

-- FULL JOIN
SELECT post.content, member.email FROM post
LEFT JOIN member ON post.member_id = member.id
UNION
SELECT post.content, member.email FROM member
RIGHT JOIN post ON member.id = post.member_id;