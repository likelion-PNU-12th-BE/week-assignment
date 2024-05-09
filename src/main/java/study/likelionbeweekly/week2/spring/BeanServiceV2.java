package study.likelionbeweekly.week2.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanServiceV2 {
    private final DefaultService defaultService;
    
    public void confirm() {
        System.out.println("defaultService = " + defaultService);
    }
}
