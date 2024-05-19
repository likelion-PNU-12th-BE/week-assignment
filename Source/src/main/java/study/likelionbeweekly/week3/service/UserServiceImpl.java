package study.likelionbeweekly.week3.service;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.repository.UserRepository;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(String id, String password) {
        User user = createUser(id, password);
        userRepository.save(user);
    }

    private User findUser(String id) {

        return userRepository.findById(id);
    }

    private User createUser(String id, String password) {
        User user = findUser(id);
        if(user == null){
            return new User(id,password);
        }else{
            throw new IllegalStateException("아이디 중복");
        }
    }

    @Override
    public User login(String id, String password, Model model) {
        User user = findUser(id);
        return compare(id, password, user, model);
    }

    private User compare(String id, String password, User user, Model model) {
        if (id.equals(user.getId()) && password.equals(user.getPassword())) {
            model.addAttribute("id", id);
            return user;
        } else {
            log.error("로그인 실패 : 사용자 ID 또는 비밀번호 불일치");
            throw new IllegalStateException("로그인 실패");
        }
    }

}
