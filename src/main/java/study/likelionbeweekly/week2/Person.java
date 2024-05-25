package study.likelionbeweekly.week2;

//자바 객체 100개 생성하기
public class Person {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Person person = new Person();
            System.out.println(person);
        }
    }
}
