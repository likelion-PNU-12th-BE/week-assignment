package study.likelionbeweekly.week2.DI;

public class NewCoffeeManager implements Manager {

    @Override
    public void makeCoffee(){
        System.out.println("NewCoffeeManager.makeCoffee");
    }
}
