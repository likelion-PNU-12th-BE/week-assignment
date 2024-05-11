package study.likelionbeweekly.week2.Field_Injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);
        PersonService personService = ctx.getBean(PersonService.class);
        System.out.println("Person name: " + personService.getPersonName());
    }
}
