package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity : 데이터를 넣을 때 알아서 다음 차례에 넣어줌.
    private Long id;

    @Column(length = 16, nullable = false) // 주로 2의 제곱수로 설정, not null
    private String name;

    @Column(length = 64, nullable = false)
    private String email;

    @CreatedDate
    private LocalDateTime createdAt; //대문자로 작성하면 '_소문자'로 바꿔줌.

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
