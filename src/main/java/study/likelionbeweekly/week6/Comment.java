package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CommentID;

    @Column(name = "Comment", nullable = false)
    private String comment;

    @Column(name = "Comment_likes", nullable = false)
    private String comment_likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PostID", nullable = false)
    private Post post;
}
