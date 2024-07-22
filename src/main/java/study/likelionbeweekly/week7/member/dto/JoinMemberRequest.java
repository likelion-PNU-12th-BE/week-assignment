package study.likelionbeweekly.week7.member.dto;

import jakarta.validation.constraints.NotBlank;

public record JoinMemberRequest(@NotBlank String name, String email, @NotBlank String password) {
}
