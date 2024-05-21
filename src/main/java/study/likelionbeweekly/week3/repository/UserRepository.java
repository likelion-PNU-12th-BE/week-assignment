package study.likelionbeweekly.week3.repository;

import study.likelionbeweekly.week3.domain.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(String id);
}
