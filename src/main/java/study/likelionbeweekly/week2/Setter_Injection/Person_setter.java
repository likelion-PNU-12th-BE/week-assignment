package study.likelionbeweekly.week2.Setter_Injection;

public class Person_setter {
    private String name;
    private int age;

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
