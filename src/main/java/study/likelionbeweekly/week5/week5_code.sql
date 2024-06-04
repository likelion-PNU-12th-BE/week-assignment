#CREATE DATABASE BulletinBoardDB;
#USE BulletinBoardDB;

/*
CREATE TABLE BulletinBoard (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    post_title VARCHAR(255) NOT NULL,
    post_content TEXT NOT NULL,
    comment_content TEXT,
    comment_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
*/

#DESCRIBE BulletinBoard;

#INSERT INTO BulletinBoard (username, email, post_title, post_content, comment_content) 
#VALUES ('user1', 'user1@example.com', 'First Post', 'This is the content of the first post.', 'This is a comment.');
#SELECT * FROM BulletinBoard;

/*
CREATE TABLE Member (
    member_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);
*/
#DESCRIBE Member;
/*
CREATE TABLE Post (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    member_id INT,
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);

DESCRIBE Post;
*/
/*
CREATE TABLE Comment (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    post_id INT,
    member_id INT,
    FOREIGN KEY (post_id) REFERENCES Post(post_id),
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);
describe Comment;
*/

/*
INSERT INTO Member (username, email, password) VALUES ('user1', 'user1@example.com', 'password1');
SELECT * FROM Member;
*/

/*
INSERT INTO Post (title, content, member_id) VALUES ('First Post', 'This is the content of the first post.', 1);
SELECT * FROM Post;
*/

/*
INSERT INTO Comment (content, post_id, member_id) VALUES ('This is a comment.', 1, 1);
SELECT * FROM Comment;
*/

#------------반정규화---------------#

/*
CREATE TABLE PostWithComments (
    post_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    member_id INT,
    member_username VARCHAR(50),
    comment_content TEXT,
    comment_created_at TIMESTAMP,
    FOREIGN KEY (member_id) REFERENCES Member(member_id)
);
*/
# DESCRIBE PostWithComments;

/*
INSERT INTO PostWithComments (title, content, member_id, member_username, comment_content, comment_created_at) 
VALUES ('First Post', 'This is the content of the first post.', 1, 'user1', 'This is a comment.', NOW());

SELECT * FROM PostWithComments;
*/