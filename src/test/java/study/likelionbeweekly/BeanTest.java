package study.likelionbeweekly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.likelionbeweekly.week2.spring.BeanConfig;
import study.likelionbeweekly.week2.spring.BeanServiceV1;
import study.likelionbeweekly.week2.spring.BeanServiceV2;
import study.likelionbeweekly.week2.spring.BeanServiceV3;

@SpringBootTest
public class BeanTest {
    @Autowired
    BeanServiceV1 beanServiceV1;

    @Autowired
    BeanServiceV2 beanServiceV2;

    @Autowired
    BeanServiceV3 beanServiceV3;

    @Autowired
    BeanConfig beanConfig;

    @Test
    void beanTest(){
        beanServiceV1.confirm(); //confirm이라는 메서드-메모리를 알려줌.
        beanServiceV2.confirm();
        beanServiceV3.confirm();
    }
    @Test
    void configTest(){
        System.out.println("beanConfig = " + beanConfig);
    }
}
