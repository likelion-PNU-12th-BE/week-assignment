package study.likelionbeweekly.week2.di;

public class NewCoffeeManager implements Manager {

    @Override
    public void makeCoffee(){
        System.out.println("NewCoffeeManager.makeCoffee");
    }
}
