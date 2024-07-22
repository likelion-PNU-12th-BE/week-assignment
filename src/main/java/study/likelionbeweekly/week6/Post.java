package study.likelionbeweekly.week6;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(length = 512, nullable = false)
    private String content;

    @JoinColumn(name="member_id")
    @ManyToOne(fetch= FetchType.LAZY, optional = false) // LAZY 안들고와도 되는 거 / null이 안되는 optional
    private Member member;


    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
