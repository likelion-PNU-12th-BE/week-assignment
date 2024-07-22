package study.likelionbeweekly.week2;

public class MakeInstance {
    public static void main(String[] args) {
        //인스턴스 100개 만들기
        for (int i= 0;  i<100 ; i++) {
            MakeInstance person = new MakeInstance();
            System.out.println(person);
        }
    }
}

//인스턴스를 100개 생성하면 각각 주소가 다 다름. 부하가 많이 발생 > 싱글톤 사용하는 거어
