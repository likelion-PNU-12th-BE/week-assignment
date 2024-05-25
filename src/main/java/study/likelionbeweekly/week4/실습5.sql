	-- 데이터베이스 생성 및 선택
CREATE DATABASE IF NOT EXISTS likeliondb;
USE likeliondb;

DROP TABLE IF EXISTS Users;

	
CREATE TABLE Users (
	id VARCHAR(10) PRIMARY KEY,
	name VARCHAR(10) NOT NULL 
   );
   
-- [기본] INSERT 명령어로 User 엔티티 삽입해보기
INSERT INTO Users VALUES("ms","minseokgo");
INSERT INTO Users VALUES("a", "asdf");
INSERT INTO Users VALUES("두디", "제수지");
INSERT INTO Users VALUES("IT", "응용공학과");


-- [기본] UPDATE 명령어로 User 엔티티 수정하기
UPDATE Users
SET name ='UPDATE_ms'
WHERE id ='ms';

	-- 수정된 후 데이터 조회
SELECT id, name
FROM Users;
