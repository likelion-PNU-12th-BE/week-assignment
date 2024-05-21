package study.likelionbeweekly.week2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {

    @Bean(name="lion_Bean")
    public Lion lion(){
        return new Lion();
    }
}
