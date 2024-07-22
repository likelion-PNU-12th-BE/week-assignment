package study.likelionBEweekly.week6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Entity // 엔티티 정의
@Getter
@Setter
@Table(name="Comment")  // 클래스 이름이 default 테이블 이름
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "like_count", nullable = false)
    private long likeCount;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
}
