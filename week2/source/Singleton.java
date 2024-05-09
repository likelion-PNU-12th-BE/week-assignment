package com.project.weekassignment.week2;

public class Singleton {
    private static Singleton instance;

    //private static Singleton instance == new Singleton(); 은 사용하지 않더라도 하나의 객체를 만들기 때문에 메모리 손해
    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
    class Main{
        public static void main(String[] args) {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = Singleton.getInstance();
                //signleton이기 때문에 출력되는 주소는 하나로 고정
                /* public static Singleton getInstance() ->  private static Singleton getInstance() 수정
                 ==>getInstance()에 접근 불가
                 -> private 형태이기 때문에 Singleton class 외부(여기서는 Main class)에서 접근 X

                 getInstance는 Singleton class가 포함하고 있는 method
                 ==> Singleton calss instance인 'singleton'에서는 호출 가능
                 */
                System.out.println(singleton);
            }
        }
    }

