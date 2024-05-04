package study.likelionbeweekly.week2;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.web.bind.annotation.RequestAttribute;

@RequiredArgsConstructor
public class People {

    private final String name; //final: 무조건 값이 들어가야함을 의미
    private final int age;
}
