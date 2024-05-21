package study.likelionbeweekly.week3.repository;

import java.util.Optional;
import study.likelionbeweekly.week3.domain.User;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(String id);
}
