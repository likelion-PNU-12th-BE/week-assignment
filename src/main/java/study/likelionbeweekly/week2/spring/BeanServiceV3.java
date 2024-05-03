package study.likelionbeweekly.week2.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeanServiceV3 {

    private final DefaultService defaultService;

    public void confirm() {
        System.out.println("defaultService = " + defaultService);
    }
}
