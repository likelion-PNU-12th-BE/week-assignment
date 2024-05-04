package study.likelionbeweekly.week2.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //스프링 컨테이너에 Bean을 올림.
public class BeanConfig {
    @Bean
    public DefaultService defaultService() {
        return new DefaultService();
    }
}
