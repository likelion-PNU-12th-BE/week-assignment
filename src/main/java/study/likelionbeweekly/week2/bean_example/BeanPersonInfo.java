package study.likelionbeweekly.week2.bean_example;

public class BeanPersonInfo {
    private String name;
    private int age;

    public BeanPersonInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
