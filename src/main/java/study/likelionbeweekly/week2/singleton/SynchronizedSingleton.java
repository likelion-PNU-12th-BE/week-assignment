package study.likelionbeweekly.week2.singleton;

import java.util.Objects;

public class SynchronizedSingleton {

    private static SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {
    }

    public static SynchronizedSingleton getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (SynchronizedSingleton.class) {
                if (Objects.isNull(INSTANCE)) {
                    INSTANCE = new SynchronizedSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
