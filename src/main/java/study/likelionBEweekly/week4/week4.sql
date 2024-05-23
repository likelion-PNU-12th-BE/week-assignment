show databases;
use likelion;

# 테이블 Users 생성 (id, name)
create table Users(
id	VARCHAR(10) PRIMARY KEY,
name	VARCHAR(10)  NOT NULL
);
show tables;

# (1234, hyerin) 데이터 추가
INSERT INTO Users (id, name) VALUE('1234', 'hyerin');
SELECT * FROM Users;

# 나머지 데이터 추가
INSERT INTO Users (id, name) VALUE('1235', 'jisu');
INSERT INTO Users (id, name) VALUE('1236', 'nuri');
SELECT * FROM Users;

# 특정 id 가진 데이터 조회
SELECT * FROM Users WHERE id = '1234';

# 특정 id 가진 데이터 수정
UPDATE Users SET name = 'jiwoo' WHERE id = '1235';

# 특정 id 가진 데이터 제거
DELETE FROM Users WHERE id = '1236';
SELECT * FROM Users;
