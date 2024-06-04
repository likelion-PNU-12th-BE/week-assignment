use likelion;

CREATE TABLE member (
    id    BIGINT    NOT NULL,
    name    VARCHAR(20)    NOT NULL,
    email    VARCHAR(100)    NOT NULL
);

CREATE TABLE post (
    id    BIGINT    NOT NULL,
    title    VARCHAR(100)    NOT NULL,
    content    VARCHAR(500)    NOT NULL,
    member_id    BIGINT    NOT NULL
);

CREATE TABLE comment (
    id    BIGINT    NOT NULL,
    content    VARCHAR(100)    NOT NULL,
    member_id    BIGINT    NOT NULL,
    post_id    BIGINT    NOT NULL
);

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
    id
);

ALTER TABLE post ADD CONSTRAINT PK_POST PRIMARY KEY (
    id
);

ALTER TABLE comment ADD CONSTRAINT PK_COMMENT PRIMARY KEY (
    id
);

ALTER TABLE post ADD CONSTRAINT FK_member_TO_post_1 FOREIGN KEY (
    member_id
)
REFERENCES member (
    id
);

ALTER TABLE comment ADD CONSTRAINT FK_member_TO_comment_1 FOREIGN KEY (
    member_id
)
REFERENCES member (
    id
);

ALTER TABLE comment ADD CONSTRAINT FK_post_TO_comment_1 FOREIGN KEY (
    post_id
)
REFERENCES post (
    id
);

SELECT * FROM member;
