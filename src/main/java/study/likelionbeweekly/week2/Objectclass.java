package study.likelionbeweekly.week2;

public class Objectclass {

    public static void main(String[] args) {   //psvm으로 생성 가능
        People people = new People("김도형", 24);
        for (int i=0; i < 100; i++){
            People people1 = new People("김도형", 24);
            System.out.println("people1 = " + people1); //soutv 단축키 > 가장 근처의 객체를 만든다?
        };

    }

}
