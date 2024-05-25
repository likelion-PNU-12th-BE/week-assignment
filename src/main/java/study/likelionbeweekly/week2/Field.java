package study.likelionbeweekly.week2;

//필드 주입 실습
import org.springframework.beans.factory.annotation.Autowired;

public class Field {
    @Autowired
    private Constructor.CocoService cocoService;
}

