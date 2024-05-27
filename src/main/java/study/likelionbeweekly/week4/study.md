>  ## 데이터베이스(DATABASE)
#### written by. @wannagola
### 1. 데이터베이스가 무엇인지 알아보기

**데이터베이스의 정의:**
- 데이터베이스(Database)는 데이터를 체계적으로 저장, 관리, 검색할 수 있는 시스템입니다.
- 데이터베이스는 데이터를 효율적으로 관리하고 검색할 수 있도록 구조화된 데이터의 모음입니다.
- 데이터베이스는 데이터의 일관성을 유지하고 중복을 최소화하며 데이터의 무결성을 보장합니다.

**데이터베이스 관리 시스템(DBMS):**
- DBMS(Database Management System)는 데이터베이스를 관리하는 소프트웨어입니다.
- DBMS는 데이터의 저장, 검색, 갱신, 삭제와 같은 작업을 수행합니다.
- 대표적인 DBMS로는 MySQL, PostgreSQL, Oracle, SQL Server 등이 있습니다.

### 2. 데이터베이스 자료형 알아보기

**자료형(Data Types):**
- 데이터베이스에서 데이터는 여러 유형으로 저장될 수 있습니다. 주요 자료형은 다음과 같습니다:
    - **정수형(Integer):** 숫자를 저장합니다. 예: `INT`, `BIGINT`
    - **실수형(Floating Point):** 소수점을 포함한 숫자를 저장합니다. 예: `FLOAT`, `DOUBLE`
    - **문자형(String):** 문자열을 저장합니다. 예: `VARCHAR`, `TEXT`
    - **날짜형(Date/Time):** 날짜와 시간을 저장합니다. 예: `DATE`, `TIMESTAMP`
    - **이진형(Binary):** 바이너리 데이터를 저장합니다. 예: `BLOB`

**자료형 사용 예시:**
```sql
CREATE TABLE example (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    registered_on DATE
);
```

### 3. 관계형 데이터베이스가 무엇인지 알아보기

**관계형 데이터베이스(Relational Database):**
- 관계형 데이터베이스는 데이터를 테이블 형태로 저장합니다.
- 각 테이블은 행(Row)과 열(Column)로 구성됩니다.
- **키(Key)** 를 사용하여 테이블 간의 관계를 정의합니다.
- **SQL(Structured Query Language)** 을 사용하여 데이터를 조작합니다.

**예시:**
```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100)
);

CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    order_date DATE,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

### 4. 비관계형 데이터베이스가 무엇인지 알아보기

**비관계형 데이터베이스(Non-Relational Database):**
- 비관계형 데이터베이스는 테이블 형식이 아닌 다양한 데이터 모델을 사용합니다.
- 데이터의 구조가 유연하고 확장성이 뛰어납니다.
- **NoSQL**이라는 용어로도 알려져 있습니다.

**비관계형 데이터베이스 유형:**
- **도큐먼트형(Document Store):** JSON, BSON 등 문서 형태로 데이터를 저장합니다. 예: MongoDB
- **키-값 저장소(Key-Value Store):** 키와 값의 쌍으로 데이터를 저장합니다. 예: Redis
- **컬럼형(Column Store):** 열 단위로 데이터를 저장합니다. 예: Cassandra
- **그래프형(Graph Database):** 그래프 구조로 데이터를 저장합니다. 예: Neo4j

**예시 (MongoDB):**
```json
{
  "user_id": 1,
  "username": "Minki Sung",
  "email": "sungmg@example.com",
  "orders": [
    {
      "order_id": 101,
      "order_date": "2024-05- 17"
    }
  ]
}
```

### 5. 관계형 vs 비관계형 데이터베이스

**비교 항목:**

| 특징 | 관계형 데이터베이스 (RDBMS) | 비관계형 데이터베이스 (NoSQL) |
|------|-----------------------------|-------------------------------|
| **데이터 모델** | 테이블 기반 | 다양한 모델 (문서, 키-값, 그래프 등) |
| **언어** | SQL | 비SQL (다양한 쿼리 언어 사용) |
| **확장성** | 수직적 확장 (서버 성능 향상) | 수평적 확장 (노드 추가) |
| **스키마** | 고정된 스키마 | 유연한 스키마 |
| **트랜잭션** | 강력한 ACID 속성 | BASE 속성 (일관성보다는 가용성 중시) |
| **사용 사례** | 전통적 응용 프로그램, 금융 데이터 | 빅 데이터, 실시간 웹 애플리케이션 |

**장단점:**

- **관계형 데이터베이스 장점:**
    - 데이터 무결성 보장
    - 강력한 트랜잭션 지원
    - 복잡한 쿼리 가능

- **관계형 데이터베이스 단점:**
    - 스키마 변경이 어렵다
    - 수직적 확장에 한계

- **비관계형 데이터베이스 장점:**
    - 높은 확장성
    - 유연한 데이터 모델링
    - 빠른 데이터 처리

- **비관계형 데이터베이스 단점:**
    - 데이터 일관성 보장이 어렵다
    - 복잡한 쿼리 지원 미약

관계형 데이터베이스(RDB)와 관련된 이 주제에 대해서도 자세히 설명하겠습니다. 각 항목을 하나씩 설명해 드리겠습니다.

### 1. 엔티티(Entity)에 대해 알아보기

**엔티티(Entity):**
- 엔티티는 데이터베이스에서 관리하고자 하는 실체를 의미합니다.
- 이는 사람이 될 수도 있고, 물건, 개념 등 다양한 형태가 될 수 있습니다.
- 엔티티는 하나 이상의 속성(Attribute)을 가지며, 이 속성들은 엔티티의 특성을 설명합니다.

**예시:**
- **학생(Student)** 엔티티: `학생ID`, `이름`, `나이`, `전공`
- **책(Book)** 엔티티: `ISBN`, `제목`, `저자`, `출판사`

### 2. 테이블(Table)에 대해 알아보기

**테이블(Table):**
- 테이블은 엔티티의 데이터를 행(Row)과 열(Column)의 형태로 저장하는 구조입니다.
- 데이터베이스에서 데이터를 체계적으로 저장, 관리하기 위해 사용됩니다.

#### 튜플(행: Row)가 무엇인지 알아보기
- **튜플(Row):** 테이블의 한 행으로, 하나의 레코드를 나타냅니다.
- 각 튜플은 테이블의 각 열(Column)에 대응되는 값을 가집니다.

**예시:**
```sql
-- Student 테이블의 예시
학생ID | 이름   | 나이 | 전공
------|------|-----|----
1     | 홍길동 | 20  | 컴퓨터공학
2     | 김영희 | 22  | 경영학
```
위의 테이블에서 각 행(Row)은 한 명의 학생에 대한 정보를 나타냅니다.

#### 어트리뷰트(열: Column)가 무엇인지 알아보기
- **어트리뷰트(Column):** 테이블의 한 열로, 데이터의 특정 속성을 나타냅니다.
- 테이블의 각 열은 고유한 데이터 타입과 제약 조건을 가질 수 있습니다.

**예시:**
```sql
-- Student 테이블의 예시
학생ID | 이름   | 나이 | 전공
```
위의 테이블에서 `학생ID`, `이름`, `나이`, `전공`은 각기 다른 속성을 나타내는 열(Column)입니다.

### 3. 기본키(PK)에 대해 알아보기

**기본키(Primary Key):**
- 기본키는 테이블 내에서 각 행을 고유하게 식별할 수 있는 하나 이상의 열(Column)입니다.
- 기본키는 반드시 유일하고(null 값을 가질 수 없는) 값을 가져야 합니다.
- 테이블에서 하나의 기본키만 설정할 수 있습니다.

**예시:**
```sql
CREATE TABLE Student (
    학생ID INT PRIMARY KEY,
    이름 VARCHAR(100),
    나이 INT,
    전공 VARCHAR(100)
);
```
위 예시에서 `학생ID`가 기본키로 설정되어 있습니다.

### 1. DDL이 무엇인지 알아보기

**DDL (Data Definition Language):**
- 데이터 정의 언어는 데이터베이스 구조를 정의하고 관리하는 데 사용되는 SQL 명령어입니다.
- 테이블, 인덱스, 뷰, 스키마 등을 생성, 수정, 삭제하는 명령어가 포함됩니다.

#### CREATE 질의어 이해하기
- **CREATE** 명령어는 새로운 데이터베이스 객체(테이블, 인덱스 등)를 생성하는 데 사용됩니다.

**예시:**
```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    major VARCHAR(50)
);
```

#### DROP 질의어 이해하기
- **DROP** 명령어는 기존의 데이터베이스 객체를 삭제하는 데 사용됩니다.

**예시:**
```sql
DROP TABLE students;
```

### 2. DML이 무엇인지 알아보기

**DML (Data Manipulation Language):**
- 데이터 조작 언어는 데이터베이스에 저장된 데이터를 조작(삽입, 수정, 삭제, 조회)하는 데 사용되는 SQL 명령어입니다.

#### SELECT 질의어 이해하기
- **SELECT** 명령어는 데이터베이스에서 데이터를 조회하는 데 사용됩니다.

**예시:**
```sql
SELECT * FROM students;
SELECT name, age FROM students WHERE major = 'Computer Science';
```

#### INSERT 질의어 이해하기
- **INSERT** 명령어는 데이터베이스에 새로운 데이터를 삽입하는 데 사용됩니다.

**예시:**
```sql
INSERT INTO students (student_id, name, age, major) VALUES (1, 'Minki Sung', 24, 'Computer Science');
```

#### UPDATE 질의어 이해하기
- **UPDATE** 명령어는 기존 데이터를 수정하는 데 사용됩니다.

**예시:**
```sql
UPDATE students SET age = 24 WHERE student_id = 1;
```

#### DELETE 질의어 이해하기
- **DELETE** 명령어는 기존 데이터를 삭제하는 데 사용됩니다.

**예시:**
```sql
DELETE FROM students WHERE student_id = 1;
```

### 3. DCL이 무엇인지 간단하게 알아보기

**DCL (Data Control Language):**
- 데이터 제어 언어는 데이터베이스의 사용자 권한을 관리하는 데 사용되는 SQL 명령어입니다.
- 권한을 부여하거나 철회하는 명령어가 포함됩니다.

**주요 명령어:**
- **GRANT:** 특정 사용자에게 권한을 부여합니다.
- **REVOKE:** 특정 사용자에게 부여된 권한을 철회합니다.

**예시:**
```sql
GRANT SELECT, INSERT ON students TO user1;
REVOKE INSERT ON students FROM user1;
```

### 4. COMMIT, ROLLBACK이 무엇인지 간단하게 알아보기

**트랜잭션 제어 명령어:**
- 데이터베이스에서 트랜잭션을 제어하는 명령어로, 데이터의 일관성과 무결성을 유지하기 위해 사용됩니다.

#### COMMIT
- **COMMIT** 명령어는 트랜잭션에서 수행된 모든 변경 사항을 영구적으로 저장합니다.

**예시:**
```sql
BEGIN;
UPDATE students SET age = 22 WHERE student_id = 2;
COMMIT;
```

#### ROLLBACK
- **ROLLBACK** 명령어는 트랜잭션에서 수행된 모든 변경 사항을 취소합니다.

**예시:**
```sql
BEGIN;
UPDATE students SET age = 22 WHERE student_id = 2;
ROLLBACK;
```