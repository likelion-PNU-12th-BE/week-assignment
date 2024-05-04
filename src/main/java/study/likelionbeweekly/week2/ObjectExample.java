package study.likelionbeweekly.week2;

public class ObjectExample {

    public static void main(String[] args) {
        People people = new People("염아연", 25); //name,age는 프로그램에서 제공하는 기능이므로 따로 안 써도 됨.

        for (int i = 0; i < 100; i++) {
            People people1 = new People("염아연", 25);
            System.out.println("people1 = " + people1); //단축기:soutv-가장 가까운 value를 출력.

        }
    }
}
