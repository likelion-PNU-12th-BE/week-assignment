package study.likelionbeweekly.week3.service;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.repository.UserRepository;

// 이곳에 서비스 빈을 등록해보세요.
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	// 이곳에 UserRepository 를 주입 받아 보세요.
	private final UserRepository userRepository;
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public void saveUser(String id, String password) {
		// 이곳에 id 와 password 로 User 를 생성해보세요.
		// 이곳에 userRepository.save 에 user 를 전달해서 정보를 저장해보세요.
		User user = createUser(id,password);
		// createUser를 때렸을때 에러가 나올경우(아이디 중복) 에러를 처리해야함 --> @Transactional로 해결한다.
		userRepository.save(user);
	}

	private User findUser(String id) {
		//return null  null 대신 userRepository.findById 에 id 를 전달해서 User 를 반환해주세요.
		return userRepository.findById(id);
	}

	private User createUser(String id, String password) {
		User user = findUser(id);
		// null 대신 findUser 에 id 전달해서 User 를 찾아와 대입해보세요.
		// 같은 id가 존재한다면 user는 user객체이고, 없다면 null이다.

		if (Objects.isNull(user)) {
			// 이곳에 id 와 password 로 새로운 user 를 만들어서 반환해보세요.
			return new User(id,password);
		} else{
			log.error("아이디 중복: {}",id);
			throw new IllegalStateException("아이디 중복");
		}
	}

	@Override
	@Transactional
	public User login(String id, String password, Model model) {
		User user = findUser(id); // null 대신 findUser 에 id 전달해서 User 를 찾아와 대입해보세요.
		return compare(id,password,user,model); // user 대신 compare 에 id, password, user, model 을 전달한 결과를 반환해보세요.
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
		} else{
			log.error("로그인 실패 : 사용자 ID 또는 비밀번호 불일치");
			throw new IllegalStateException("로그인 실패");
		}
	}

}
