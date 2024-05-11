package study.likelionbeweekly.week2.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppConfigService {

    private final ApplicationConfig applicationConfig;

    public void confirm() {
        System.out.println("applicationConfig = " + applicationConfig);
    }
}
