package study.likelionbeweekly.di;

public class CoffeeManger implements Manager {

    @Override
    public void makeCoffee() {
        System.out.println("CoffeeManger.makeCoffee");
    }
}
