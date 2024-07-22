package study.likelionbeweekly.week3;

public class OutputView {
    public void printProfile(Student student){
        System.out.println(
                "내 이름은 " + student.getName() + "입니다."
        );
        System.out.println(
                "내 나이는 " + student.getAge() + "입니다."
        );
    }
}
