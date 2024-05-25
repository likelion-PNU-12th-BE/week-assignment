	-- 데이터베이스 생성 및 선택
CREATE DATABASE IF NOT EXISTS likeliondb;
USE likeliondb;

DROP TABLE IF EXISTS Users;

	-- [기본] CREATE 명령어로 Users 테이블 생성해보기
CREATE TABLE Users (
	id VARCHAR(10) PRIMARY KEY,
	name VARCHAR(10) NOT NULL 
   );
   
