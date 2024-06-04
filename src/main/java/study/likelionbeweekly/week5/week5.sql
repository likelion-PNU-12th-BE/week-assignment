USE
likelion;

DROP TABLE IF EXISTS member;

CREATE TABLE member
(
    id         BIGINT       NOT NULL PRIMARY KEY,
    name       VARCHAR(20)  NOT NULL,
    email      VARCHAR(100) NOT NULL unique,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL
);

DROP TABLE IF EXISTS post;

CREATE TABLE post
(
    id         BIGINT       NOT NULL PRIMARY KEY,
    title      VARCHAR(100) NOT NULL,
    content    VARCHAR(500) NOT NULL,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL,
    member_id  BIGINT       NOT NULL
);

DROP TABLE IF EXISTS comment;

CREATE TABLE comment
(
    id         BIGINT       NOT NULL PRIMARY KEY,
    content    VARCHAR(100) NOT NULL,
    created_at DATETIME     NOT NULL,
    updated_at DATETIME     NOT NULL,
    is_deleted BOOLEAN      NOT NULL,
    member_id  BIGINT       NOT NULL,
    post_id    BIGINT       NOT NULL
);

ALTER TABLE post ADD CONSTRAINT FK_member_TO_post_1 FOREIGN KEY (member_id)
REFERENCES member (id);

ALTER TABLE comment ADD CONSTRAINT FK_member_TO_comment_1 FOREIGN KEY (member_id)
REFERENCES member (id);

ALTER TABLE comment ADD CONSTRAINT FK_post_TO_comment_1 FOREIGN KEY (post_id)
REFERENCES post (id);

SHOW TABLES;

INSERT INTO member(id, name, email, created_at, updated_at, is_deleted)
VALUES (1, 'minseok', 'rhalstjr1999@naver.com', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false);

SELECT * FROM member;

INSERT INTO post(id, title, content, created_at, updated_at, is_deleted, member_id)
VALUES (1, 'Hello World', 'Bye World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1);

INSERT INTO post(id, title, content, created_at, updated_at, is_deleted, member_id)
VALUES (2, 'Where World', 'Here World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1);

INSERT INTO post(id, title, content, created_at, updated_at, is_deleted, member_id)
VALUES (3, 'Here World', 'There World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1);

SELECT * FROM post;

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (1, 'Hello World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 1);

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (2, 'Bye World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 1);

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (3, 'Where World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 2);

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (4, 'Here World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 1);

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (5, 'Here World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 3);

INSERT INTO comment(id, content, created_at, updated_at, is_deleted, member_id, post_id)
VALUES (6, 'Here World', '2024-05-23 13:13:13', '2024-05-23 13:13:13', false, 1, 4);

SELECT * FROM comment;

-- post 와 member JOIN
SELECT * FROM post
JOIN member ON post.member_id = member.id;

-- ID가 1인 멤버가 작성한 댓글 목록
SELECT * FROM comment
JOIN member ON comment.member_id = 1;

-- post 를 통해 댓글과 멤버 조인 게시물 조회
SELECT * FROM post
JOIN member ON post.member_id = member.id
JOIN comment ON post.id = comment.post_id;

-- comment 를 통해 게시물과 멤버 조인하고 댓글 조회
SELECT * FROM comment
JOIN member ON comment.member_id = member.id
JOIN post ON comment.post_id = post.id;

-- LEFT JOIN
SELECT * FROM post
LEFT JOIN comment ON post.id = comment.post_id;

-- RIGHT JOIN: FK가 NOT NULL 이라 테스트 불가..
SELECT * FROM comment
RIGHT JOIN post ON comment.post_id = post.id;

-- FULL JOIN
SELECT * FROM post
LEFT JOIN comment ON post.id = comment.post_id

UNION

SELECT * FROM post
RIGHT JOIN comment ON post.id = comment.post_id;
