### 1. 정규화 (Normalization)

#### [기본] 정규화의 목적과 중요성 알아보기
정규화의 목적은 데이터베이스에서 데이터를 구조화하여 중복을 줄이고 무결성을 유지하는 것입니다. 이를 통해 데이터의 일관성을 유지하고 저장 공간을 절약하며 데이터베이스 성능을 최적화할 수 있습니다. 정규화는 데이터베이스 설계의 기본 원칙 중 하나로, 잘 설계된 데이터베이스는 정규화 과정을 통해 이루어집니다.

#### [기본] 정규화의 종류 알아보기 (1NF, 2NF, 3NF, BCNF)

1. **1NF (제1정규형)**
    - **정의**: 각 필드는 원자값(더 이상 분해할 수 없는 값)을 가져야 합니다.
    - **예시**:
      ```sql
      -- 비정규화된 테이블
      CREATE TABLE Students (
        StudentID INT,
        Name VARCHAR(100),
        Subjects VARCHAR(100) -- Math, Science
      );
      ```
      이 테이블에서는 `Subjects` 필드에 여러 과목이 쉼표로 구분되어 저장됩니다.

      ```sql
      -- 1NF로 정규화
      CREATE TABLE Students (
        StudentID INT,
        Name VARCHAR(100),
        Subject VARCHAR(100)
      );
      ```
      이 테이블은 각 과목을 개별적인 레코드로 저장하여 각 필드가 원자값을 갖도록 합니다.

2. **2NF (제2정규형)**
    - **정의**: 1NF를 만족하고, 기본키가 아닌 모든 속성이 기본키에 대해 완전 함수 종속을 가져야 합니다.
    - **예시**:
      ```sql
      -- 비정규화된 테이블
      CREATE TABLE Enrollment (
        StudentID INT,
        CourseID INT,
        StudentName VARCHAR(100),
        CourseName VARCHAR(100)
      );
      ```
      이 테이블에서는 `StudentName`과 `CourseName`이 각각 `StudentID`와 `CourseID`에 의해 결정되지만 부분적으로 종속되어 있습니다.

      ```sql
      -- 2NF로 정규화
      CREATE TABLE Students (
        StudentID INT,
        StudentName VARCHAR(100)
      );
 
      CREATE TABLE Courses (
        CourseID INT,
        CourseName VARCHAR(100)
      );
 
      CREATE TABLE Enrollment (
        StudentID INT,
        CourseID INT
      );
      ```
      이 구조에서는 학생 정보와 코스 정보를 각각 별도의 테이블로 분리하여 `Enrollment` 테이블이 학생과 코스 간의 관계만을 표현합니다.

3. **3NF (제3정규형)**
    - **정의**: 2NF를 만족하고, 기본키가 아닌 모든 속성이 기본키에 대해 이행적 함수 종속을 갖지 않아야 합니다.
    - **예시**:
      ```sql
      -- 비정규화된 테이블
      CREATE TABLE Employees (
        EmpID INT,
        EmpName VARCHAR(100),
        DeptID INT,
        DeptName VARCHAR(100)
      );
      ```
      이 테이블에서는 `DeptName`이 `DeptID`에 의해 결정되므로 이행적 함수 종속이 발생합니다.
    >릴레이션에서 X, Y, Z라는 3 개의 속성이 있을 때 X→Y, Y→Z 이란 종속 관계가 있을 경우, X→Z가 성립될 때 이행적 함수 종속이라고 합니다.
   
      ```sql
      -- 3NF로 정규화
      CREATE TABLE Employees (
        EmpID INT,
        EmpName VARCHAR(100),
        DeptID INT
      );
 
      CREATE TABLE Departments (
        DeptID INT,
        DeptName VARCHAR(100)
      );
      ```
      이 구조에서는 `DeptID`와 `DeptName`을 별도의 `Departments` 테이블로 분리하여 이행적 종속성을 제거합니다.

4. **BCNF (보이스-코드 정규형)**
    - **정의**: 3NF를 만족하고, 모든 결정자가 후보키이어야 합니다.
    - **예시**:
      ```sql
      -- 비정규화된 테이블
      CREATE TABLE Courses (
        CourseID INT,
        InstructorID INT,
        InstructorName VARCHAR(100),
        CourseName VARCHAR(100)
      );
      ```
      이 테이블에서는 `InstructorName`이 `InstructorID`에 의해 결정되지만, `InstructorID`가 후보키가 아닙니다.

      ```sql
      -- BCNF로 정규화
      CREATE TABLE Courses (
        CourseID INT,
        CourseName VARCHAR(100)
      );
 
      CREATE TABLE Instructors (
        InstructorID INT,
        InstructorName VARCHAR(100)
      );
 
      CREATE TABLE CourseInstructors (
        CourseID INT,
        InstructorID INT
      );
      ```
      이 구조에서는 `CourseID`와 `InstructorID`를 별도의 테이블로 분리하여 모든 결정자가 후보키가 되도록 합니다.

#### [기본] 반정규화 알아보기
반정규화는 성능 향상이나 시스템 제한으로 인해 의도적으로 정규화된 데이터베이스 구조를 일부 풀어 중복 데이터를 허용하는 것입니다. 예를 들어, 자주 조회되는 데이터를 포함하도록 테이블을 조정하여 조회 성능을 높일 수 있습니다.

### 2. 외래키(FK)와 연관 관계

#### 외래키(Foreign Key; FK)
- **정의**: 다른 테이블의 기본키를 참조하는 속성.
- **역할**: 테이블 간의 관계를 정의하고 데이터 무결성을 유지합니다.
- **설정 방법 및 주의점**:
  ```sql
  CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
  );
  ```
  **설명**:
    - `Orders` 테이블의 `CustomerID` 필드는 `Customers` 테이블의 `CustomerID`를 참조하는 외래키입니다.
    - 이를 통해 `Orders` 테이블의 각 주문이 어떤 고객과 연관되어 있는지 명확히 합니다.

#### 연관 관계
- **일대일(1:1)**: 한 레코드가 다른 테이블의 한 레코드와 연관.
  ```sql
  CREATE TABLE Passports (
    PassportID INT PRIMARY KEY,
    PersonID INT UNIQUE,
    FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
  );
  ```
  **설명**:
    - `Passports` 테이블의 `PersonID` 필드는 `Persons` 테이블의 `PersonID`를 참조하며, 각 사람이 하나의 여권만 가질 수 있도록 합니다.

- **다대일(N:1)**: 여러 레코드가 다른 테이블의 한 레코드와 연관.
  ```sql
  CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
  );
  ```
  **설명**:
    - `Orders` 테이블의 여러 주문이 `Customers` 테이블의 하나의 고객과 연관될 수 있습니다.

- **다대다(N:M)**: 여러 레코드가 다른 테이블의 여러 레코드와 연관.
  ```sql
  CREATE TABLE StudentCourses (
    StudentID INT,
    CourseID INT,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
  );
  ```
  **설명**:
    - `StudentCourses` 테이블은 학생과 코스 간의 다대다 관계를 나타내며, 각 학생은 여러 코스를 수강할 수 있고, 각 코스는 여러 학생이 수강할 수 있습니다.

### 3. CRUD와 조인

#### CRUD 기본
- **Create (등록)**:
  ```sql
  INSERT INTO Students (StudentID, Name) VALUES (1, 'Minki Sung');
  ```
  **설명**:
    - `Students` 테이블에 새로운 학생 데이터를 삽입합니다. `StudentID`가 1이고 `Name`이 'Minki Sung'인 레코드를 추가합니다.
    - 이 쿼리는 새로운 학생 정보를 데이터베이스에 추가합니다.

- **Read (조회)**:
  ```sql
  SELECT * FROM Students;
  ```
  **설명**:
    - `Students` 테이블의 모든 데이터를 조회합니다.
    - 이 쿼리는 모든 학생의 정보를 데이터베이스에서 검색합니다.

- **Update (수정)**:
  ```sql
  UPDATE Students SET Name = 'Minki Sung' WHERE StudentID = 1;
  ```
  **설명**:
    - `Students` 테이블에서 `StudentID`가 1인 학생의 `Name`을 'Minki Sung'으로 수정합니다.
    - 이 쿼리는 특정 학생의 이름을 변경합니다.

- **Delete (삭제)**:
  ```sql
  DELETE FROM Students WHERE StudentID = 1;
  ```
  **설명**:
    - `Students` 테이블에서 `StudentID`가 1인 학생의 데이터를 삭제합니다.
    - 이 쿼리는 특정 학생의 정보를 데이터베이스에서 제거합니다.

#### 조인 기초
- **INNER JOIN**: 두 테이블에서 일치하는 레코드만 반환.
  ```sql
  SELECT Students.Name, Courses.CourseName
  FROM Students
  INNER JOIN StudentCourses ON Students.StudentID = StudentCourses.StudentID
  INNER