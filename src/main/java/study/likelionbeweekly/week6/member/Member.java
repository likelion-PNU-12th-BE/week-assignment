package study.likelionbeweekly.week6.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.likelionbeweekly.week6.post.Post;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 12, nullable = false)
    private String phoneNumber;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isDeleted;

}
