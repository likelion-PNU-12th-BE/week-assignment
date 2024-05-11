package study.likelionbeweekly.week2.configuration;

import study.likelionbeweekly.week2.Person_config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Person_config person() {
        return new Person_config("Minki Sung", 24);
    }
}
