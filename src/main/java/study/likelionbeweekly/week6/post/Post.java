package study.likelionbeweekly.week6.post;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.likelionbeweekly.week6.member.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Member member;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 1024, nullable = false)
    private String content;

    @Column(columnDefinition = "BIGINT DEFAULT 0")
    private Long views;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted;

}
