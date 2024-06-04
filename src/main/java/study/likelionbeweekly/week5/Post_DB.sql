CREATE DATABASE IF NOT EXISTS likeliondb;
USE likeliondb;

DROP TABLE IF EXISTS Comments;
DROP TABLE IF EXISTS Posts;	
DROP TABLE IF EXISTS Members;	-- 외래 키 제약조건 때문에 마지막에 삭제 


CREATE TABLE `Members` (
	`UserID` VARCHAR(10) PRIMARY KEY,	-- 기본 키들은 간편하게 테이블 생성할 때 생성하는 걸로 수정
	`email`	VARCHAR(50)	NOT NULL,
	`password`	VARCHAR(10)	NOT NULL
);

CREATE TABLE `Posts` (
	`PostID`  BIGINT PRIMARY KEY,
	 UserID VARCHAR(10),	
	`title`	VARCHAR(100)	NOT NULL,
	`content`	TEXT	NULL,
	`likes`	int	NULL	DEFAULT  0,
    FOREIGN KEY (`UserID`) REFERENCES `Members`(`UserID`)	-- 외래 키 설정
);

CREATE TABLE `Comments` (
	`CommentID`	BIGINT PRIMARY KEY,
     UserID VARCHAR(10),
	`comment`	VARCHAR(100)	NOT NULL,
	`comment_like`	int	NOT NULL,
    FOREIGN KEY (`UserID`) REFERENCES `Members`(`UserID`)	-- 외래 키 설정 
);


    