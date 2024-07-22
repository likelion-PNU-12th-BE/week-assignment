package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // comment 가 post 를 참조
    // 다대일 관계 매핑
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
