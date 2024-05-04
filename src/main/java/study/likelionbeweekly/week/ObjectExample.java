package study.likelionbeweekly.week;

public class ObjectExample {

    public static void main(String[] args) {
        People people = new People("고민석", 26);

        for (int i = 0; i < 100; i++) {
            People people1 = new People("고민석", 26);
            System.out.println("people1 = " + people1);
        }
    }
}
