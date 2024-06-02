create database week5;
use week5;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`id`	varchar(20)	NOT NULL,
	`name`	varchar(10)	NOT NULL,
	`email`	varchar(20)	NOT NULL,
	`password`	varchar(20)	NOT NULL,
	`nick`	varchar(10)	NOT NULL
);

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
	`num`	int	NOT NULL,
	`content`	varchar(200)	NOT NULL,
	`img`	varchar(200)	NULL,
	`like`	int	NOT NULL	DEFAULT 0,
	`Field`	VARCHAR(255)	NULL,
	`user_id`	varchar(20)	NOT NULL
);

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
	`com_id`	varchar(20)	NOT NULL,
	`comment`	varchar(100)	NOT NULL,
	`com_like`	int	NOT NULL	DEFAULT 0,
	`posts_num`	int	NOT NULL
);

ALTER TABLE `member` ADD CONSTRAINT `PK_member` PRIMARY KEY (
	`id`
);

ALTER TABLE `posts` ADD CONSTRAINT `PK_posts` PRIMARY KEY (
	`num`
);

ALTER TABLE `comment` ADD CONSTRAINT `PK_comment` PRIMARY KEY (
	`com_id`
);

ALTER TABLE `posts` ADD CONSTRAINT `FK_member_TO_posts_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `member` (
	`id`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_posts_TO_comment_1` FOREIGN KEY (
	`posts_num`
)
REFERENCES `posts` (
	`num`
);

show tables