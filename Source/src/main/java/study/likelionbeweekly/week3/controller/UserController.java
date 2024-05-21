package study.likelionbeweekly.week3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import study.likelionbeweekly.week3.service.UserService;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

// 이곳에 컨트롤러 빈을 등록해보세요.P
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loginPage() {
        return "signIn";
    }

    @GetMapping("/joinPage")
    public String joinPage() {
        return "signUp";
    }

    @PostMapping("/join")
    public String join(@RequestParam("id") String id,
        @RequestParam("password") String password) {
        userService.saveUser(id, password);
        return "signIn";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
        @RequestParam("password") String password, Model model) {
        userService.login(id, password, model);
        return "info";
    }

}
