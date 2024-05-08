package study.likelionbeweekly.week2.makeinstance;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class java_makeinstance {
    // 메인 클래스
    public static class Main {
        public static void main(String[] args) {
            // Person 객체를 저장할 배열 생성
            Person[] people = new Person[100];

            // 100개의 Person 객체 생성
            for (int i = 0; i < 100; i++) {
                people[i] = new Person("Person " + (i + 1), i);
            }

            // 생성된 모든 객체의 정보 출력
            for (Person person : people) {
                person.displayInfo();
            }
        }
    }


}


