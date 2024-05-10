package study.likelionbeweekly.week2.di;

import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    // 필드 주입
    // @Autowired
    // private Manager manager;

    // Setter 주입
    // private Manager manager;

    // @Autowired
    // public void setManager(Manager manager) {
    //     this.manager = manager;
    // }

    private final Manager manager;

    // 생성자 주입
    public CoffeeService(Manager manager) {
        this.manager = manager;
    }

    public void sale() {
        manager.makeCoffee();
    }
}
