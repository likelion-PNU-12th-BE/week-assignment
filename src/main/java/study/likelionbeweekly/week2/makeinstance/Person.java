package study.likelionbeweekly.week2.makeinstance;

// Person 클래스 정의
class Person {
    private String name;
    private int age;

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 이름과 나이를 출력하는 메서드
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
