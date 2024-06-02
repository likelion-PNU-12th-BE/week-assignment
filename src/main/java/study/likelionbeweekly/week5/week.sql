create table comment
(
    id        bigint not null auto_increment,
    content   varchar(255),
    member_id bigint,
    post_id   bigint,
    primary key (id)
);

create table member
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
);

create table post
(
    id        bigint not null auto_increment,
    content   varchar(255),
    title     varchar(255),
    member_id bigint,
    primary key (id)
);

alter table comment
    add constraint FKmrrrpi513ssu63i2783jyiv9m
        foreign key (member_id)
            references member (id);

alter table comment
    add constraint FKs1slvnkuemjsq2kj4h3vhx7i1
        foreign key (post_id)
            references post (id);

alter table post
    add constraint FK83s99f4kx8oiqm3ro0sasmpww
        foreign key (member_id)
            references member (id);

insert into member(name)
values ('a'),
       ('b'),
       ('c'),
       ('d'),
       ('e'),
       ('f');

insert into post(content, title, member_id)
values ('content1', 'title1', 1),
       ('content2', 'title2', 1),
       ('content3', 'title3', 2),
       ('content4', 'title4', 2),
       ('content5', 'title5', 3),
       ('content6', 'title6', 3),
       ('content7', 'title7', 4),
       ('content8', 'title8', 4);

insert into comment(content, member_id, post_id)
values ('content1', 1, 1),
       ('content2', 2, 1),
       ('content3', 3, 2),
       ('content4', 4, 2),
       ('content5', 1, 3),
       ('content6', 2, 3),
       ('content7', 3, 4),
       ('content8', 4, 4);

# inner join
    select *
from member
         join post p on member.id = p.member_id;

# left join
    select *
from member
         left join post p on member.id = p.member_id;

# right join
    select *
from member
         right join post p on member.id = p.member_id;

# full join
    select *
from member
         left join post p on member.id = p.member_id

union

select *
from member
         right join post p on member.id = p.member_id;