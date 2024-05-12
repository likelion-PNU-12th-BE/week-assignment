package study.likelionbeweekly.week2.DI;

import org.springframework.stereotype.Service;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.print();
    }
}

public class Controller{

    private final Service service;

    public Controller(){
        this.service = new Service();
    }

    public void print(){
        System.out.println(service.message());
    }
}

class Service{

    public String message(){
        return "Hello World";
    }
}