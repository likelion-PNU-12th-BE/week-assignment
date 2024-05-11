package practice.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ConstructInjection")
public class ConstructInjection {
    private final DependentObject1 dependentObject1;
    private final DependentObject2 dependentObject2;
    @Autowired
    public ConstructInjection(DependentObject1 dependentObject1,DependentObject2 dependentObject2){
        this.dependentObject1 = dependentObject1;
        this.dependentObject2 = dependentObject2;
    }
}
