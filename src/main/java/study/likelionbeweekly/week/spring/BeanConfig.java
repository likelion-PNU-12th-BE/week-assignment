package study.likelionbeweekly.week.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public DefaultService defaultService() {
        return new DefaultService();
    }
}
