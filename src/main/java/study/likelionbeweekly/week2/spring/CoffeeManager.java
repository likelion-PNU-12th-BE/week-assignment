package study.likelionbeweekly.week2.spring;

import org.apache.catalina.Manager;

public class CoffeeManager implements Manager {

        @Override
        public void makeCoffee() {
            System.out.println("CoffeeManger.makeCoffee");
        }
}
