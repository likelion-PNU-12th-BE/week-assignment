package study.likelionbeweekly.week6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Member {
    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

//    // 일대다 관계 매핑, 양방향 매핑
//    @OneToMany(mappedBy = "member")
//    private List<Post> posts;
//    member 는 post 를 참조 필요 없음
}
