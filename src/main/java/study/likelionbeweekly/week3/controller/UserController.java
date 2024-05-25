package study.likelionbeweekly.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.likelionbeweekly.week3.service.UserService;

// 이곳에 컨트롤러 빈을 등록해보세요.
@Controller
public class UserController {

	// 이곳에 UserService를 주입 받아 보세요.
	private final UserService userService; //UserService 빈 등록하기

	@Autowired	//생성자 주입
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/" 입니다.
	 */
	@GetMapping("/")	//@GetMapping은 내가 보내고자 하는 데이터를 URL에 실어서 보냄
	public String loginPage() {

		return "signIn";
	}

	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/joinPage" 입니다.
	 */
	@GetMapping("/joinPage")
	public String joinPage() {

		return "signUp";
	}

	/**
	 * 이곳에 POST 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/join" 입니다.
	 */
	@PostMapping("/join")	//@PostMapping는 안 보이게 바디에 실어서 전달
	public String join(@RequestParam("id") String id,
					   @RequestParam("password") String password) {

		// 이곳에 userService.saveUser 에 id와 password 를 전달해서 User 를 저장해보세요.
		userService.saveUser(id, password);

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
