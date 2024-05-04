package study.likelionbeweekly.week2.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public DefaultService defaultService() {
        return new DefaultService();
    }
}
