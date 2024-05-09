package study.likelionbeweekly.week2.DI;

public class CoffeeService {
    private final Manager coffeeManager;

    public CoffeeService(Manager coffeeManager) {
        this.coffeeManager = coffeeManager;
    }

    public void sale(){
        coffeeManager.makeCoffee();
    }
}
