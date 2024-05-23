create table Users(
id	VARCHAR(10) PRIMARY KEY,
name VARCHAR(10) NOT NULL);
show tables;

INSERT INTO Users (id, name) VALUE('0210', 'karryun');
SELECT * FROM Users;

INSERT INTO Users (id, name) VALUE('0211', 'pecon');
INSERT INTO Users (id, name) VALUE('0212', 'class');
SELECT * FROM Users;

SELECT * FROM Users WHERE id = '0212';

UPDATE Users SET name = 'doyeon' WHERE id = '0212';

DELETE FROM Users WHERE id = '0211';
SELECT * FROM Users;