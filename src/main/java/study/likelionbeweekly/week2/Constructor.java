package study.likelionbeweekly.week2;

//생성자 주입 실습
public class Constructor {
    private final CocoService cocoService;

    public Constructor(CocoService cocoService) {
        this.cocoService = cocoService;
    }

    public static class CocoService {

    }
}

