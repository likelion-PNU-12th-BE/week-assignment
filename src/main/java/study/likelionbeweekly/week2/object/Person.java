package study.likelionbeweekly.week2.object;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {

    private final String name;
    private final int age;

    public void walk() {
        System.out.println(this + "Person.walk");
    }

    public void run() {
        System.out.println(this + "Person.run");
    }
}
