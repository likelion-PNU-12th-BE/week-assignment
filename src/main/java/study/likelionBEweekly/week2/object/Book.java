package study.likelionBEweekly.week2.object;

public class Book {
    private String name;
    private int serialNum;
    private String writer;

    public Book(String name, int serialNum) {
        this.name = name;
        this.serialNum = serialNum;
    }
    public Book(String name, int serialNum, String writer) {
        this.name = name;
        this.serialNum = serialNum;
        this.writer = writer;
    }

    // 출력
    public String toString() {
        return "name: "+this.name+", serialNum: "+this.serialNum;
    }
}
