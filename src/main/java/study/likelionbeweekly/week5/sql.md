## ERD
![ERD.png](image%2FERD.png)
### Members
- 멤버 id - PK
- 멤버이름
- 전화번호
- 삭제여부
- 생성일자
- 생정시간
### Posts
- 게시글 id - PK
- 멤버 id - FK
- 제목
- 내용
- 조회수
- 삭제여부
- 생성일자
- 생성시간
### Comments
- 댓글 id - PK
- 게시글 id - FK
- 멤버 id - FK
- 댓글 내용
- 추천수
- 비추천수
- 삭제여부
- 생성일자
- 생성시간
## CRUD
### CREATE

```
CREATE TABLE `Comments` (
         `comment_id` BIGINT AUTO_INCREMENT  PRIMARY KEY NOT NULL,  
         `post_id` BIGINT NOT NULL COMMENT 'auto increment',  
         `member_id` BIGINT NOT NULL COMMENT 'auto increment',  
         `comment_content` VARCHAR(300) NULL,  
         `status` BOOLEAN NULL DEFAULT 0,  
         `create_date` DATE NULL,  
         `create_time` TIMESTAMP NULL,  
         `thumbs_up` BIGINT NULL,  
         `thumbs_down` BIGINT NULL )
```
```
CREATE TABLE `Posts` (  
        `post_id` BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT 'auto increment',  
        `member_id` BIGINT NOT NULL COMMENT 'auto increment',  
        `post_title` VARCHAR(50) NULL,  
        `post_content` VARCHAR(300) NULL,  
        `views` BIGINT NULL DEFAULT 0,  
        `status` BOOLEAN NULL DEFAULT 0,  
        `create_date` DATE NULL,  
        `create_time` TIMESTAMP NULL )
```
```
CREATE TABLE `Members` (  
        `member_id` BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY COMMENT 'auto increment',  
        `member_name` VARCHAR(30) NULL,  
        `phone_number` VARCHAR(100) NOT NULL,  
        `status` BOOLEAN NULL DEFAULT 0,  
        `create_date` DATE NULL,  
        `create_time` TIMESTAMP NULL )
```

### Insert
```
-- Members 테이블에 데이터 삽입
INSERT INTO `Members` (`member_name`, `phone_number`, `status`, `create_date`, `create_time`)
VALUES
    ('Alice', '123-456-7890', 0, '2024-01-01', '2024-01-01 10:00:00'),
    ('Bob', '098-765-4321', 0, '2024-02-01', '2024-02-01 11:00:00'),
    ('Charlie', '111-222-3333', 0, '2024-03-01', '2024-03-01 12:00:00');
```
![members.png](image%2Fmembers.png)
```
INSERT INTO `Comments` (`post_id`, `member_id`, `comment_content`, `status`, `create_date`, `create_time`, `thumbs_up`, `thumbs_down`)
VALUES
    (2, 'This is a comment on the first post.', 0, '2024-01-03', '2024-01-03 16:00:00', 10, 2),
    (3, 'This is a comment on the second post.', 0, '2024-02-03', '2024-02-03 17:00:00', 20, 3),
    (1, 'This is a comment on the third post.', 0, '2024-03-03', '2024-03-03 18:00:00', 30, 4);
```
![comments.png](image%2Fcomments.png)

```
INSERT INTO `Posts` (`member_id`, `post_title`, `post_content`, `views`, `status`, `create_date`, `create_time`)
VALUES
    (1, 'First Post', 'This is the content of the first post.', 100, 0, '2024-01-02', '2024-01-02 13:00:00'),
    (2, 'Second Post', 'This is the content of the second post.', 200, 0, '2024-02-02', '2024-02-02 14:00:00'),
    (3, 'Third Post', 'This is the content of the third post.', 300, 0, '2024-03-02', '2024-03-02 15:00:00');
```
![posts.png](image%2Fposts.png)
### Delete
```
DELETE FROM Members WHERE member_name = 'Alice';
DELETE FROM Members WHERE create_date < '2023-01-01';
```

### Update
```
UPDATE 
    Members 
SET 
    phone_number = '987-654-3210' 
    WHERE 
        member_id = 1;
```
![update.png](image%2Fupdate.png)
---
## JOIN
### Inner join
InnerJoin을 사용하여 게시글을 작성한 멤버들을 조회
```
SELECT
    m.member_id,
    m.member_name,
    p.post_id,
    p.post_title,
    p.post_content,
    p.views,
    p.status,
    p.create_date,
    p.create_time
FROM
    Members m
INNER JOIN
    Posts p ON m.member_id = p.member_id;
```
![innerjoin.png](image%2Finnerjoin.png)

### Left outer join
LEFT OUTER JOIN을 사용하여 Posts를 기준으로 모든 게시글을 반환하고,일치하는 멤버와 댓글이 있으면 그 값을 반환하며, 일치하는 레코드가 없으면 NULL을 반환
```
SELECT
    m.member_id AS member_id,
    m.member_name AS member_name,
    p.post_id AS post_id,
    p.post_title AS post_title,
    p.post_content AS post_content,
    c.comment_id AS comment_id,
    c.comment_content AS comment_content
FROM
    Posts p
LEFT JOIN
    Members m ON p.member_id = m.member_id
LEFT JOIN
    Comments c ON p.post_id = c.post_id;
```
![leftjoin.png](image%2Fleftjoin.png)

### right outer join 
RIGHT OUTER JOIN을 사용하여 Comments를 기준으로 모든 댓글을 반환하고, 일치하는 게시글과 멤버가 있으면 그 값을 반환하며, 일치하는 레코드가 없으면 NULL을 반환

```
SELECT 
    m.member_id AS member_id,
    m.member_name AS member_name,
    p.post_id AS post_id,
    p.post_title AS post_title,
    p.post_content AS post_content,
    c.comment_id AS comment_id,
    c.comment_content AS comment_content
FROM 
    Posts p
RIGHT JOIN 
    Members m ON p.member_id = m.member_id
RIGHT JOIN 
    Comments c ON p.post_id = c.post_id;
```
![rightjoin.png](image%2Frightjoin.png)

### full outer join 
MySQL에서는 FULL OUTER JOIN을 직접 지원하지 않으므로, LEFT JOIN과 RIGHT JOIN을 UNION하여 구현
```
SELECT 
    m.member_id AS member_id,
    m.member_name AS member_name,
    p.post_id AS post_id,
    p.post_title AS post_title,
    p.post_content AS post_content,
    c.comment_id AS comment_id,
    c.comment_content AS comment_content
FROM 
    Posts p
LEFT JOIN 
    Members m ON p.member_id = m.member_id
LEFT JOIN 
    Comments c ON p.post_id = c.post_id

UNION

SELECT 
    m.member_id AS member_id,
    m.member_name AS member_name,
    p.post_id AS post_id,
    p.post_title AS post_title,
    p.post_content AS post_content,
    c.comment_id AS comment_id,
    c.comment_content AS comment_content
FROM 
    Posts p
RIGHT JOIN 
    Members m ON p.member_id = m.member_id
RIGHT JOIN 
    Comments c ON p.post_id = c.post_id;
```
![fulljoin.png](image%2Ffulljoin.png)