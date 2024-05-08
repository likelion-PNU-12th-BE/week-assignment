package study.likelionbeweekly.week2.bean_example;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BeanPersonInfo person() {
        return new BeanPersonInfo("Minki", 24);
    }
}
