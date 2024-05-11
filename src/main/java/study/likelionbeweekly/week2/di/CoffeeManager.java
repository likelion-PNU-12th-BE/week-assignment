package study.likelionbeweekly.week2.di;

public class CoffeeManager implements Manager {

    @Override
    public void makeCoffee(){
        System.out.println("CoffeeManager.makeCoffee");
    }
}
