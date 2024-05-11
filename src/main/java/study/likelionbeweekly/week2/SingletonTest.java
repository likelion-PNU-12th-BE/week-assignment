package study.likelionbeweekly.week2;

public class SingletonTest {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Singleton singleton = Singleton.getInstance();
			System.out.println(singleton);
		}
	}
}

class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}