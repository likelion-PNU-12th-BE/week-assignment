create table Users ( # User 테이블 생성
    id varchar(10), 
    name varchar(10) NOT NULL, # NULL 값 허용 x
    primary key (id) # id를 기본키로 설정
); 

insert into Users values('qwerty', 'minseokgo'); # 엔티티 삽입
insert into Users values('qwertyu', 'junseokbae'); # 엔티티 삽입

select * from users; # users의 모든 엔티티 조회

select * from users where name='minseokgo'; # users에서 이름이 minseokgo인 튜플 조회 

update users # 엔티티 정보 수정
set name = 'junseokkim' # id가 qwerty인 튜플의 이름을 junseokbae로 수정
where id = 'qwertyu'

delete from users where id = 'qwertyu'