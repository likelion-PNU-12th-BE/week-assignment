package study.likelionbeweekly.week2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 애노테이션으로 스프링 컨테이너에 빈 등록하기
@Configuration
public class AppConfig {

    @Bean   //스프링 컨테이너에 빈을 등록하는 메서드
    public MyBean myBean() {
        return new MyBean();
    }

    public static class MyBean {

    }
}

