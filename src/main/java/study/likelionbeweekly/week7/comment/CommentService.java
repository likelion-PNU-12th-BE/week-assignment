package study.likelionbeweekly.week7.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.likelionbeweekly.week7.comment.dto.UpdateCommentRequest;
import study.likelionbeweekly.week7.member.Member;
import study.likelionbeweekly.week7.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import study.likelionbeweekly.week7.comment.dto.CreateCommentRequest;
import study.likelionbeweekly.week7.post.Post;
import study.likelionbeweekly.week7.post.PostRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
/* createcomment
    {
            "content": "댓글 내용",
            "memberId": 1, // 댓글 작성자 ID
            "postId": 1 // 게시글 ID
    }
*/
    public void createComment(CreateCommentRequest request) {

        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(EntityNotFoundException::new);

        Post post = postRepository.findById(request.postId())
                .orElseThrow(EntityNotFoundException::new);

        String createContent = request.content();
        Comment comment = new Comment(createContent, member, post);
        commentRepository.save(comment);
    }

    @Transactional
    public void updateComment(Long id, UpdateCommentRequest request) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        comment.setContent(request.content());
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        comment.setDeleted(true);
    }
}
