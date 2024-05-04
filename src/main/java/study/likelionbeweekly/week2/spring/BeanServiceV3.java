package study.likelionbeweekly.week2.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // 생성자로서 final이 있는 값을 초기화시켜줌.
public class BeanServiceV3 {
    private final DefaultService defaultService;
    
    public void confirm() {
        System.out.println("defaultService = " + defaultService);
    }
}
