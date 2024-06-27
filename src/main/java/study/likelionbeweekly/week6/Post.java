package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // post 는 member 을 참조
    // 다대일 관계 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
