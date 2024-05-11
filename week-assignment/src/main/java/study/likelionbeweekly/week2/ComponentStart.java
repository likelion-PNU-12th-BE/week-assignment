package study.likelionbeweekly.week2;

//@Component 어노테이션으로 클래스 레벨 빈 만들기
import org.springframework.stereotype.Component;

@Component
public class ComponentStart {
    public void doSomething() {
        System.out.println("MyComponent is doing something");
    }

}
