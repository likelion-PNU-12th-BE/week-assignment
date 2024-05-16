package study.likelionbeweekly.week2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("SetterInjection")
public class SetterInjection {

    private DependentObject1 dependentObject1;
    private DependentObject2 dependentObject2;

    @Autowired
    public void setDependentObject1(DependentObject1 dependentObject1){
        this.dependentObject1 = dependentObject1;
    }

    @Autowired
    public void setDependentObject2(DependentObject2 dependentObject2){
        this.dependentObject2 = dependentObject2;
    }
}
