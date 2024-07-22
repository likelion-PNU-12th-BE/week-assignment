package study.likelionbeweekly.session2.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.lanwen.verbalregex.VerbalExpression;

public class CustomEmailValidator implements ConstraintValidator<CustomEmail, String> {

	// 전체 이메일 형식
	private VerbalExpression emailRegex;

	@Override
	public void initialize(final CustomEmail constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);

		VerbalExpression.Builder userPart = VerbalExpression.regex()
			.range("a", "z", "A", "Z", "0", "9") // 사용자 이름 범위
			.oneOrMore();                         // 하나 이상의 문자

		VerbalExpression.Builder domainPart = VerbalExpression.regex()
			.range("a", "z", "A", "Z", "0", "9") // 도메인 범위
			.oneOrMore()                                   // 하나 이상의 문자
			.then(".")                                     // 점
			.range("a", "z", "A", "Z")                     // 도메인 확장자
			.atLeast(2)                                    // 최소 두 자 이상
			.endOfLine();                                   // 문자열 끝

		emailRegex = VerbalExpression.regex()
			.add(userPart)  // 사용자 이름 부분 추가
			.then("@")      // '@' 기호
			.add(domainPart) // 도메인 부분 추가
			.build();
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		return emailRegex.testExact(value);
	}
}
