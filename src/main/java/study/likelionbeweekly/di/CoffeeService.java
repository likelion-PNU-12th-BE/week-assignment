package study.likelionbeweekly.di;

public class CoffeeService {

    private final CoffeeManger coffeeManger;

    public CoffeeService() {
        this.coffeeManger = new CoffeeManger();
    }

    public void sale() {
        coffeeManger.makeCoffee();
    }
}
