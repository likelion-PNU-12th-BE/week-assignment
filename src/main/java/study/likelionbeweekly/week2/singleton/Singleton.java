package study.likelionbeweekly.week2.singleton;

import java.util.Objects;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
