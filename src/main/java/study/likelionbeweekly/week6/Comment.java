package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 256, nullable = false)
    private String content;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch= FetchType.LAZY, optional = false)
    private Member member;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    private Post post;

    @CreatedDate //데이터 생성된 시점 기록하는 자동화 필요
    private LocalDateTime createAt; // 대문자At인 이유 자동으로 대문자 시작부터 _at로 바뀐다

    @LastModifiedDate // 수정 시간 기록
    private LocalDateTime updatedAt; // 최신 클래스

    @Column(columnDefinition="boolean default false")
    private boolean isDeleted;

}
