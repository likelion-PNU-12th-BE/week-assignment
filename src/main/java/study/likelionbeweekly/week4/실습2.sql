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

-- [기본] SELECT 명령어로 User 엔티티 조회하기
SELECT id, name
FROM Users;

-- [기본] WHERE 절을 통해 User id 가 minseokgo 인 튜플 찾아보기
SELECT id, name
FROM Users
WHERE id = 'ms';
