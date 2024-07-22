package study.likelionbeweekly.week7.member;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;
import study.likelionbeweekly.week7.member.dto.JoinMemberRequest;
import study.likelionbeweekly.week7.member.dto.LoginMemberRequest;
import study.likelionbeweekly.week7.member.dto.UpdateMemberRequest;

@WebMvcTest(MemberController.class)
class MemberControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MemberService memberService;

	@Autowired
	private ObjectMapper om;

	@Test
	void testLogin() throws Exception {
		final LoginMemberRequest request = new LoginMemberRequest("test@gmail.com", "password");

		doNothing().when(memberService).loginMember(request);

		mockMvc.perform(get("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(request)))
			.andExpect(status().isOk())
			.andExpect(content().string("ok"))
			.andDo(print());

		verify(memberService).loginMember(request);
	}

	@Test
	void testInvalidJoinParameters() throws Exception {
		final JoinMemberRequest nameErrorRequest = new JoinMemberRequest(" ", "test@gmail.com", "password");
		final JoinMemberRequest emailErrorRequest = new JoinMemberRequest("hello", "notEmailForm", "password");
		final JoinMemberRequest passwordErrorRequest = new JoinMemberRequest("hello", "test@gmail.com", " ");

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(nameErrorRequest)))
			.andExpect(status().isBadRequest())
			.andExpect(result -> MethodArgumentNotValidException.class.equals(
				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(emailErrorRequest)))
			.andExpect(status().isBadRequest())
			.andExpect(result -> MethodArgumentNotValidException.class.equals(
				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(passwordErrorRequest)))
			.andExpect(status().isBadRequest())
			.andExpect(result -> MethodArgumentNotValidException.class.equals(
				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
	}

	@Test
	void testJoin() throws Exception {
		final JoinMemberRequest request = new JoinMemberRequest("hello", "test@gmail.com", "password");

		doNothing().when(memberService).joinMember(request);

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(request)))
			.andExpect(status().isOk())
			.andExpect(content().string("ok"))
			.andDo(print());

		verify(memberService).joinMember(request);
	}

	@Test
	void testUpdate() throws Exception {
		final UpdateMemberRequest request = new UpdateMemberRequest("hello", "test@gmail.com", "newPassword");

		final Long updateId = 1L;
		doNothing().when(memberService).updateMember(updateId, request);

		mockMvc.perform(patch("/members/{id}", updateId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(request)))
			.andExpect(status().isOk())
			.andExpect(content().string("ok"))
			.andDo(print());

		verify(memberService).updateMember(updateId, request);
	}

	@Test
	void testInvalidUpdateId() throws Exception {
		final UpdateMemberRequest request = new UpdateMemberRequest("hello", "test@gmail.com", "newPassword");

		final Long invalidUpdateId = -1L;

		mockMvc.perform(patch("/members/{id}", invalidUpdateId)
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(request)))
			.andExpect(status().isBadRequest())
			.andExpect(result -> MethodArgumentNotValidException.class.equals(
				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
	}

	@Test
	void testDelete() throws Exception {
		final Long deleteId = 1L;
		doNothing().when(memberService).deleteMember(deleteId);

		mockMvc.perform(delete("/members/{id}", deleteId))
			.andExpect(status().isOk())
			.andExpect(content().string("ok"))
			.andDo(print());

		verify(memberService).deleteMember(deleteId);
	}

	@Test
	void testInvalidDeleteId() throws Exception {
		final Long invalidDeleteId = -1L;

		doNothing().when(memberService).deleteMember(invalidDeleteId);

		mockMvc.perform(delete("/members/{id}", invalidDeleteId))
			.andExpect(status().isBadRequest())
			.andExpect(result -> MethodArgumentNotValidException.class.equals(
				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
	}
}