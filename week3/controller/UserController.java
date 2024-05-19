package study.likelionbeweekly.week3.controller;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.service.UserService;
import study.likelionbeweekly.week3.service.UserServiceImpl;

// 이곳에 컨트롤러 빈을 등록해보세요.
@Controller
public class UserController {

	// 이곳에 UserService 를 주입 받아 보세요.
	private UserService userService = new UserServiceImpl();
	/**
	 * 인터페이스
	 * 기능 A
	 * 기능 B
	 *
	 * 구현체 1
	 * 기능 A
	 * 기능 B
	 * 구현체 2
	 * 기능 A
	 * 기능 B
	 * 인터페이스 객체 vs 클래스 객체
	 *
	 * 기능 A 와 기능 B가 위치한 주소만 알고있다
	 * 주소에 있는 기능만 실행한다. -> 일관성
	 * 구현체1, 구현체2
	 */
	/**
	 * 이곳에 GET 요청을 받아오는 애노테이션을 작성해 보세요.
	 * 요청 주소는 "/" 입니다.
	 */
	@GetMapping("/")
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
	@PostMapping("/join")
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
