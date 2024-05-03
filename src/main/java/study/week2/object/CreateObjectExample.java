package study.week2.object;

public class CreateObjectExample {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Person person = new Person(String.valueOf(i), 20);
            System.out.println("person = " + person);
            person.walk();
            person.run();
            System.out.println();
        }
    }
}
