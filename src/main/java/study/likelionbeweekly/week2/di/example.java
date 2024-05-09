package study.likelionbeweekly.week2.di;

public class example {

    public static void main(String[] args) {

        CoffeeManager coffeeManager = new CoffeeManager();
        NewCoffeeManager newCoffeeManager = new NewCoffeeManager();

        CoffeeService coffeeService1 = new CoffeeService(coffeeManager);
        CoffeeService coffeeService2 = new CoffeeService(newCoffeeManager);
        CoffeeService coffeeService3 = new CoffeeService(new CoffeeManager());

        coffeeService1.sale();
        coffeeService2.sale();
    }
}
