package study.likelionbeweekly.week7.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import study.likelionbeweekly.week7.member.dto.JoinMemberRequest;

@AutoConfigureMockMvc
@SpringBootTest
public class MemberControllerBootTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper om;

	@Test
	void testInvalidDTOJoinParameters() throws Exception {
		final JoinMemberRequest emailErrorRequest = new JoinMemberRequest("", "notEmailForm", "");

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(emailErrorRequest)))
			//			.andExpect(status().isBadRequest())
			//			.andExpect(result -> MethodArgumentNotValidException.class.equals(
			//				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
	}

	@Test
	void testInvalidEmailJoinParameters() throws Exception {
		final JoinMemberRequest emailErrorRequest = new JoinMemberRequest("hello", "invalidEmailForm", "password");

		mockMvc.perform(post("/members")
				.contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(emailErrorRequest)))
			//			.andExpect(status().isBadRequest())
			//			.andExpect(result -> MethodArgumentNotValidException.class.equals(
			//				Objects.requireNonNull(result.getResolvedException()).getClass()))
			.andDo(print());
	}
}
