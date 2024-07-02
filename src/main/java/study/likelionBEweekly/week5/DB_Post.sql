USE likelion;

CREATE TABLE member (
    id BIGINT NOT NULL AUTO_INCREMENT,
    pw VARCHAR(40) NOT NULL,
    name VARCHAR(40) NOT NULL,
    nickname VARCHAR(40) NOT NULL,
    email VARCHAR(60) NOT NULL,
    phone_num VARCHAR(40) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id)
);

CREATE TABLE post (
    post_id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    view_count BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    member_id BIGINT NOT NULL,
    PRIMARY KEY (post_id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);

CREATE TABLE comment (
    comment_id BIGINT NOT NULL AUTO_INCREMENT,
    content VARCHAR(500) NOT NULL,
    like_count BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_deleted BOOLEAN NOT NULL DEFAULT FALSE,
    member_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    PRIMARY KEY (comment_id),
    FOREIGN KEY (member_id) REFERENCES member(id),
    FOREIGN KEY (post_id) REFERENCES post(post_id)
);

## CRUD 실습 - CREATE는 위 ERD 실습으로 완료

## READ
SHOW TABLES;
SELECT * FROM Member;
SELECT * FROM Comment;
SELECT * FROM Post;


## UPDATE
INSERT INTO member (pw, name, nickname, email, phone_num) 
	VALUES	('123', 'hyerin', 'mo0n_wh1te', 'ohyerin02@naver.com', '010-1234-5678'),
			('234', 'hana', 'one', 'one@naver.com', '010-2345-3456');
SELECT * FROM member;

SET sql_safe_updates = 0;
UPDATE member SET pw = '987' WHERE pw = '123';
SELECT * FROM member;
SET sql_safe_updates = 1;


## DELETE
SET sql_safe_updates = 0;
DELETE FROM member WHERE nickname = 'one';
SET sql_safe_updates = 1;
SELECT * FROM member;


## inner join
SELECT * FROM member m INNER JOIN post p ON m.id = p.member_id;

## left join
SELECT * FROM member m LEFT JOIN post p ON m.id = p.member_id;

## right join
SELECT * FROM member m RIGHT JOIN post p ON m.id = p.member_id;

## full join (mySQL은 FULL OUTER JOIN 지원X)
SELECT * FROM member m LEFT JOIN post p ON m.id = p.member_id
UNION
SELECT * FROM member m RIGHT JOIN post p ON m.id = p.member_id;

## key가 일치한다면, 대신 USING(id)도 된다
## ON 대신 WHERE도 된다