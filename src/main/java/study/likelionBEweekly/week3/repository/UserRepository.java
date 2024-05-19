package study.likelionBEweekly.week3.repository;

import study.likelionBEweekly.week3.domain.User;

public interface UserRepository {

    void save(User user);

    User findById(String id);
}
