package study.likelionbeweekly.week7.member;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;

	@Test
	void invalidNameMember() {
		Member invalidNameMember = new Member("", "test@gmail.com", "password");
		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidNameMember));
	}

	@Test
	void blankEmailMember() {
		Member invalidEmailMember = new Member("name", "", "password");
		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidEmailMember));
	}

	@Test
	void invalidEmailMember() {
		Member invalidEmailMember1 = new Member("name", "asdf", "password");
		Member invalidEmailMember2 = new Member("name", "@", "password");
		Member invalidEmailMember3 = new Member("name", "asdf@", "password");
		Member invalidEmailMember4 = new Member("name", "asdf@gmail.", "password");

		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidEmailMember1));
		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidEmailMember2));
		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidEmailMember3));
		assertThrows(ConstraintViolationException.class, () -> repository.save(invalidEmailMember4));
	}

	@Test
	void inValidPasswordMember() {
		Member inValidPasswordMember = new Member("name", "asdf@gmail.com", "");
		assertThrows(ConstraintViolationException.class, () -> repository.save(inValidPasswordMember));
	}

	@Test
	void validMember() {
		Member invalidEmailMember = new Member("name", "asdf@gmail.com", "password");
		assertDoesNotThrow(() -> repository.save(invalidEmailMember));
	}
}