package study.likelionbeweekly.di;

public class CoffeeService {

    private final Manager manager;

    public CoffeeService(Manager manager) {
        this.manager = manager;
    }

    public void sale() {
        manager.makeCoffee();
    }
}
