package study.likelionbeweekly.week7.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import study.likelionbeweekly.week7.BaseEntity;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

	@Size(min = 3)
	@Column(length = 16, nullable = false)
	private String name;

	@Email
	@NotBlank
	@Column(length = 64, nullable = false)
	private String email;

	@NotBlank
	@Column(length = 1024, nullable = false)
	private String password;
}
