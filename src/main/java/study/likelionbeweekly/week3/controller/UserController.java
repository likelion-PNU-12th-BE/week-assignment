package study.likelionbeweekly.week3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.likelionbeweekly.week3.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
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
