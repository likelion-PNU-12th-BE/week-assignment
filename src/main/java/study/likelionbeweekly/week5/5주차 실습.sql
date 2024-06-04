
-- 데이터베이스 초기 설정
CREATE TABLE Members (
    MemberID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL
);

CREATE TABLE Posts (
    PostID INT PRIMARY KEY AUTO_INCREMENT,
    MemberID INT NOT NULL,
    Title VARCHAR(100) NOT NULL,
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

CREATE TABLE Comments (
    CommentID INT PRIMARY KEY AUTO_INCREMENT,
    PostID INT NOT NULL,
    MemberID INT NOT NULL,
    CommentText TEXT NOT NULL,
    FOREIGN KEY (PostID) REFERENCES Posts(PostID),
    FOREIGN KEY (MemberID) REFERENCES Members(MemberID)
);

-- 데이터 삽입
INSERT INTO Members (MemberID, Username, Email) VALUES
(1,'minji', 'minji@naver.com'),
(2,'hanni', 'hanni@naver.com'),
(3,'harein', 'harein@naver.com');

-- Posts 데이터 삽입
INSERT INTO Posts (PostID, MemberID, Title) VALUES
(1, 1, 'Hype boy'),
(2, 2, 'OMG');


-- Comments 데이터 삽입
INSERT INTO Comments (CommentID, PostID, MemberID, CommentText) VALUES
(1, 1, 1, 'best meme song'),
(2, 2, 2, 'my favorite song');

-- Members 테이블 조회
SELECT * FROM Members;

-- Posts 테이블 조회
SELECT * FROM Posts;

-- Comments 테이블 조회
SELECT * FROM Comments;

-- 조인 (JOIN)으로 조회하기
-- 1. INNER JOIN
SELECT Members.Username, Posts.Title, Comments.CommentText
FROM Members
INNER JOIN Posts ON Members.MemberID = Posts.MemberID
INNER JOIN Comments ON Posts.PostID = Comments.PostID;

-- 2. LEFT JOIN
SELECT Members.Username, Posts.Title
FROM Members
LEFT JOIN Posts ON Members.MemberID = Posts.MemberID;

-- 3. RIGHT JOIN
SELECT Posts.Title, Members.Username
FROM Posts
RIGHT JOIN Members ON Members.MemberID = Posts.MemberID;

-- 4. FULL JOIN
SELECT Members.Username, Posts.Title
FROM Members
LEFT JOIN Posts ON Members.MemberID = Posts.MemberID
UNION
SELECT Members.Username, Posts.Title
FROM Posts
RIGHT JOIN Members ON Members.MemberID = Posts.MemberID;
