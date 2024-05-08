package study.likelionbeweekly.week2.Component;

import org.springframework.stereotype.Component;

@Component
public class PersonComponent {
    private String name;
    private int age;

    public PersonComponent() {
        // 기본 생성자
        this.name = "John Doe";
        this.age = 30;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
