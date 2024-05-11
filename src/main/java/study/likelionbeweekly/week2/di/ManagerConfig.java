package study.likelionbeweekly.week2.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagerConfig {

    @Bean
    public Manager manager() {
        return new NewCoffeeManager();
    }
}
