package study.likelionbeweekly.week3.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public void saveUser(String id, String password) {
		User user = createUser(id, password);
		userRepository.save(user);
	}

	private User createUser(String id, String password) {
		try {
			findUser(id);
		} catch (IllegalStateException e) {
			return new User(id, password);
		}
		throw new IllegalStateException("아이디 중복");
	}

	@Override
	public User login(String id, String password, Model model) {
		User user = findUser(id);
		return compare(id, password, user, model);
	}

	private User findUser(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		throw new IllegalStateException("등록된 유저 없음");
	}

	private User compare(String id, String password, User user, Model model) {
		if (id.equals(user.getId()) && password.equals(user.getPassword())) {
			model.addAttribute("id", id);
			return user;
		}
		throw new IllegalStateException("로그인 실패");
	}
}
