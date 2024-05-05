package study.likelionbeweekly.week2.spring;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    private final Manager manager;


    public CoffeeService(Manager manager) {
        this.manager = manager;
    }

    public void sale() {
        manager.makeCoffee();
    }
}

