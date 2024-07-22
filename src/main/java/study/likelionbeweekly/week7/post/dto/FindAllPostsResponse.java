package study.likelionbeweekly.week7.post.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import study.likelionbeweekly.week7.post.Post;

public record FindAllPostsResponse(@NotNull List<FoundPost> posts) {

	public static FindAllPostsResponse of(List<Post> posts) {
		return new FindAllPostsResponse(
			posts.stream()
				.map(post -> new FoundPost(post.getId(), post.getTitle(), post.getMember().getName()))
				.toList());
	}

	private record FoundPost(Long id, String title, String memberName) {
	}
}
