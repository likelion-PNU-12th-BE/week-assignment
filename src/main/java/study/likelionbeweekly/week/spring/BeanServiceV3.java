package study.likelionbeweekly.week.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanServiceV3 {

    private final DefaultService defaultService;

    public void confirm() {
        System.out.println("defaultService = " + defaultService);
    }
}
