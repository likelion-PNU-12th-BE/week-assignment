package study.likelionbeweekly.week2.singleton;

public class SingletonExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = Singleton.getInstance();
                System.out.println("singleton = " + singleton);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = Singleton.getInstance();
                System.out.println("singleton = " + singleton);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = Singleton.getInstance();
                System.out.println("singleton = " + singleton);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
