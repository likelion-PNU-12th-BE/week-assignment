package study.likelionbeweekly.week6.comment;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import study.likelionbeweekly.week6.member.Member;
import study.likelionbeweekly.week6.post.Post;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Member members;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Post posts;

    @Column(length = 1024, nullable = false)
    private String content;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long thumbsUp;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long thumbsDown;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted;

}
