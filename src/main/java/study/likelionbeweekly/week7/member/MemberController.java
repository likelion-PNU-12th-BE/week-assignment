package study.likelionbeweekly.week7.member;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.likelionbeweekly.week7.member.dto.JoinMemberRequest;
import study.likelionbeweekly.week7.member.dto.LoginMemberRequest;
import study.likelionbeweekly.week7.member.dto.UpdateMemberRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final MemberService memberService;

	@GetMapping
	public ResponseEntity<String> login(@RequestBody LoginMemberRequest request) {
		memberService.loginMember(request);
		return ResponseEntity.ok().body("ok");
	}

	@PostMapping
	public ResponseEntity<String> join(@RequestBody @Valid JoinMemberRequest request) {
		memberService.joinMember(request);
		return ResponseEntity.ok().body("ok");
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable("id") @Min(1) Long id,
		@RequestBody UpdateMemberRequest request) {

		memberService.updateMember(id, request);
		return ResponseEntity.ok().body("ok");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") @Min(1) Long id) {
		memberService.deleteMember(id);
		return ResponseEntity.ok().body("ok");
	}
}
