#testdb라는 데이터베이스 생성하기
#CREATE DATABASE testdb;
  
#testdb라는 데이터베이스 사용하기
USE testdb;

#Users라는 테이블 testdb 내에 생성하기
/*CREATE TABLE Users (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(10) NOT NULL
);
*/

#INSERT 명령어로 User 엔티티 삽입해보기
#INSERT INTO Users (id, name) VALUES ('minkisung', 'Minkisung');

#SELECT 명령어로 User 엔티티 조회하기
#SELECT * FROM Users WHERE id = 'minkisung';

#UPDATE 명령어로 User 엔티티 수정하기
#UPDATE Users SET name = 'Minkisung2' WHERE id = 'minkisung';

#DELETE 명령어로 User 엔티티 삭제하기
#DELETE FROM Users WHERE id = 'minkisung';

#SELECT 명령어로 Users 테이블 조회하기
#SELECT * FROM Users;

#각 단계별 실행 후 다 주석 처리했음. 각 코드에 영향을 주기 때문.