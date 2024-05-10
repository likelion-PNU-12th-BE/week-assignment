package com.example.weekassignment.week2;

public class Singleton {
    //프라이빗 싱글톤 객체 '생성'
    private static Singleton instance;

    //생성자
    private Singleton() {
    }

    //private 생성자를 다른 클래스에서 사용 가능하도록
    public static Singleton getInstance() {
        //요청할때만 싱글톤 생성하도록 > 메모리 효율
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
//클래스명과 생성자명이 동일해서 가독성 안좋음.

//테스트
class Main{
    public static void main(String[] args) {
        for (int i= 0;  i<100 ; i++) {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton);
        }
    }
}
//실행 결과인 인스턴스 100개 주소가 모두 동일
