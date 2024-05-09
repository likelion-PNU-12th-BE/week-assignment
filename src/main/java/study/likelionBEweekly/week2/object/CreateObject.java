package study.likelionBEweekly.week2.object;

public class CreateObject {
    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            Book book = new Book(String.valueOf(i), i);
            System.out.println(book.toString());
        }
    }
}
