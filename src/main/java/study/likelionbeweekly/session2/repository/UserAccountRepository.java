package study.likelionbeweekly.session2.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.likelionbeweekly.session2.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
	Optional<UserAccount> findByUsername(String username);
}
