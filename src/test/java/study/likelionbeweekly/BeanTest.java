package study.likelionbeweekly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.likelionbeweekly.week2.spring.BeanServiceV1;
import study.likelionbeweekly.week2.spring.BeanServiceV2;
import study.likelionbeweekly.week2.spring.BeanServiceV3;

@SpringBootTest
class BeanTest {

    @Autowired
    BeanServiceV1 beanServiceV1;

    @Autowired
    BeanServiceV2 beanServiceV2;

    @Autowired
    BeanServiceV3 beanServiceV3;

    @Test
    void singletonBeanTest() {
        beanServiceV1.confirm();
        beanServiceV2.confirm();
        beanServiceV3.confirm();
    }
}
