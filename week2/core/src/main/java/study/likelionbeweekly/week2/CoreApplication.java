package study.likelionbeweekly.week2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
		Lion[] lions = new Lion[100];
		for(int i=0;i<100;i++){
			lions[i] = new Lion();
		}

	}



}
