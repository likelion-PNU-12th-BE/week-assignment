package study.likelionbeweekly.di;

public class NewCoffeeManager implements Manager {

    @Override
    public void makeCoffee() {
        System.out.println("NewCoffeeManager.makeCoffee");
    }
}
