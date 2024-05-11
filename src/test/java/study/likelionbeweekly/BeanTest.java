package study.likelionbeweekly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.likelionbeweekly.week2.spring.BeanConfig;
import study.likelionbeweekly.week2.spring.BeanService;
import study.likelionbeweekly.week2.spring.BeanService2;
import study.likelionbeweekly.week2.spring.BeanService3;

@SpringBootTest
public class BeanTest {

    @Autowired
    BeanService beanService;

    @Autowired
    BeanService2 beanService2;

    @Autowired
    BeanService3 beanService3;

    @Autowired
    BeanConfig beanConfig;

    @Test
    void beanTest(){
        beanService.confirm();
        beanService2.confirm();
        beanService3.confirm();
    }
    
    @Test
    void configTest(){
        System.out.println("beanConfig = " + beanConfig);
        
    }
}
