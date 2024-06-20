package study.likelionbeweekly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "study.likelionbeweekly.week2.*"))
public class LikelionBeWeeklyApplication {
    public static void main(String[] args) {
        SpringApplication.run(LikelionBeWeeklyApplication.class, args);
    }
}
