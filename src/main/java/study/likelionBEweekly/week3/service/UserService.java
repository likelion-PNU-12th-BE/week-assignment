package study.likelionBEweekly.week3.service;

import org.springframework.ui.Model;
import study.likelionBEweekly.week3.domain.User;

public interface UserService {

    void saveUser(String id, String password);

    User login(String id, String password, Model model);
}
