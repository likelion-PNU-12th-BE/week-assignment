package study.likelionbeweekly.session2.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomEmailValidatorTest {

	private ConstraintValidator validator;

	@BeforeEach
	void setUp() {
		validator = new CustomEmailValidator();
		validator.initialize(null);
	}

	@Test
	public void testValidEmails() {
		assertTrue(validator.isValid("test@example.com", null));
	}

	@Test
	public void testInvalidEmails() {
		assertFalse(validator.isValid("invalid-email", null));
		assertFalse(validator.isValid("user@domain..com", null));
		assertFalse(validator.isValid("user@domain", null));
		assertFalse(validator.isValid("@domain.com", null));
		assertFalse(validator.isValid("user@.com", null));
		assertFalse(validator.isValid("user.name@domain.co", null));
		assertFalse(validator.isValid("user+mailbox@domain.com", null));
		assertFalse(validator.isValid("user@sub.domain.com", null));
	}
}