
USE bulletinboarddb;

#inner join
/*
SELECT Post.title, Member.username
FROM Post
INNER JOIN Member ON Post.member_id = Member.member_id;
*/

#left join
/*
SELECT Post.title, Comment.content
FROM Post
LEFT JOIN Comment ON Post.post_id = Comment.post_id;
*/

#right join
/*
SELECT Member.username, Post.title
FROM Member
RIGHT JOIN Post ON Member.member_id = Post.member_id;
*/

#full join(union으로 구현)
/*
SELECT Member.username, Post.title
FROM Member
LEFT JOIN Post ON Member.member_id = Post.member_id
UNION
SELECT Member.username, Post.title
FROM Member
RIGHT JOIN Post ON Member.member_id = Post.member_id;
*/