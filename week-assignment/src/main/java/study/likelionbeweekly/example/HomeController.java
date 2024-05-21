package study.likelionbeweekly.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller //데이터를 담아서 뷰를 반환
//@ResponseBody // 데이터 자체를 응답
@RestController
public class HomeController {

    // GET, POST
    @GetMapping
    public String home() {
        return "hello"; //hello.html
    }

    @PostMapping
    public String home2() {
        return "signIn";
    }

    // 내가 보내고자하는 데이터를 URL에 실어서 보내요
    @GetMapping("/login/{id}")
    public String login(
            @PathVariable("id") String id
    ) {
        System.out.println("id = " + id);
        return "signIn";
    }

    // 쿼리 파라미터 (key=value)
    @GetMapping("/home")
    public String asdf(
            @RequestParam("id") String id,
            @RequestParam("name") String name
    ) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "ok";
    }

    // 얘는 데이터를 안보이게 전달함 => 메시지 바디에 실어서 보냄
    @PostMapping("/login")
    public String join(
            @RequestParam("id") String id) {
        System.out.println("id = " + id);
        return "signIn";
    }
}
