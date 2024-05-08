package study.likelionbeweekly.week2.Setter_Injection;
public class Main {
    public static void main(String[] args) {
        // Person 객체 생성
        Person_setter person = new Person_setter();

        // Setter 메서드를 사용하여 값 설정
        person.setName("Minki");
        person.setAge(24);

        // Getter 메서드를 사용하여 값 읽기
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
