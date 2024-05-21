package study.likelionbeweekly.week3.service;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.repository.InMemoryUserRepository;
import study.likelionbeweekly.week3.repository.UserRepository;

// 이곳에 서비스 빈을 등록해보세요.
@Slf4j
@Service
	public class UserServiceImpl implements UserService {

	private final UserRepository userRepository = new InMemoryUserRepository();

	// 이곳에 UserRepository 를 주입 받아 보세요.
	@Override
	public void saveUser(String id, String password) {
		// 이곳에 id 와 password 로 User 를 생성해보세요.
		// 이곳에 userRepository.save 에 user 를 전달해서 정보를 저장해보세요.
		User user = createUser(id, password);
		userRepository.save(user);
	}

	private User findUser(String id) {
		return userRepository.findById(id);// null 대신 userRepository.findById 에 id 를 전달해서 User 를 반환해주세요.
	}

	private User createUser(String id, String password) {
		User user = findUser(id); // null 대신 findUser 에 id 전달해서 User 를 찾아와 대입해보세요.

		if (user == null) {
            return new User(id, password);
			// 이곳에 id 와 password 로 새로운 user 를 만들어서 반환해보세요.
		}
		log.info("아이디 중복");
		//throw new IllegalStateException("아이디 중복");
		return user;
    }

	@Override
	public User login(String id, String password, Model model) {
        return compare(id, password, findUser(id), model); // user 대신 compare 에 id, password, user, model 을 전달한 결과를 반환해보세요.
	}

	/**
	 * 이 코드는 user 의 정보가 일치하는지 확인합니다.
	 * 일치한다면 페이지에 id 정보를 반환하고,
	 * 그렇지 않다면 에러를 일으킵니다.
	 */
	private User compare(String id, String password, User user, Model model) {
		if (id.equals(user.getId()) && password.equals(user.getPassword())) {
			model.addAttribute("id", id);
			return user;
		}
		log.info("로그인 실패");
		//throw new IllegalStateException("로그인 실패");
		return user;
	}
}
