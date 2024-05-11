package study.likelionbeweekly.week2;

public class ObjectExample {
    public static void main(String[] args) {
        people people = new people( "곽도연",23);

        for(int i = 0; i<=100; i++){
            people people1 = new people("곽도연",23);
            System.out.println("people1 = " + people1);
        }
    }
}
