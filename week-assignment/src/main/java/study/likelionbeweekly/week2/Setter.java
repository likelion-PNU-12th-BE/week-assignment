package study.likelionbeweekly.week2;

//Setter 주입 실습
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //Setter 클래스를 Spring 빈으로 등록
public class Setter {
    private Constructor.CocoService cocoService;

    @Autowired
    public void setCocoService(Constructor.CocoService cocoService) {
        this.cocoService = cocoService;
    }
}

