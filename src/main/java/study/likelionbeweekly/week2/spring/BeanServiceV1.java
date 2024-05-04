package study.likelionbeweekly.week2.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component //Bean으로 등록
@RequiredArgsConstructor
public class BeanServiceV1 {
    private final DefaultService defaultService;
    
    public void confirm() {
        System.out.println("defaultService = " + defaultService);
    }
}
