package study.likelionbeweekly.week2.DI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class Controller {

        @Autowired
        private Service service;

}
