package study.likelionbeweekly.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("FieldInjection")
public class FieldInjection {

    @Autowired
    private DependentObject1 dependentObject1;
    @Autowired
    private DependentObject2 dependentObject2;
}
