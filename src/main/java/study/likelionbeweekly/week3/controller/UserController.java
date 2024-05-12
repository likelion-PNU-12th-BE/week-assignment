package study.likelionbeweekly.week3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	// 이곳에 UserService 를 주입 받아 보세요.

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/" 입니다.
	 */
	@GetMapping
	//@GetMapping("/") 요청주소가 "/"일 경우 안 써도 자동으로 해준다.
	public String loginPage() {
		return "signIn";
	}

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/joinPage" 입니다.
	 */
	@GetMapping("/joinPage") //Get은 URL에 나오고 Post는 URL에 안 나온다.
	public String joinPage() {
		return "signUp";
	}

	/**
	 * 이곳에 POST 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/join" 입니다.
	 */
	@PostMapping("/join")
	public String join(@RequestParam("id") String id,
					   @RequestParam("password") String password) {
		//User user = new User(id, password); saveUser에서 생성하기 떄문에 여기서 할 필요가 없다.
		userService.saveUser(id, password);
		// 이곳에 userService.saveUser 에 id와 password 를 전달해서 User 를 저장해보세요.
		return "signIn";
	}

	/**
	 * 이곳에 POST 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/login" 입니다.
	 */
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("password") String password, Model model) {

		// 이곳에 userService.login 에 id, password 그리고 model 을 전달해서 로그인해보세요.
		userService.login(id, password, model);
		return "info";
	}
}
