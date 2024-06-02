package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id 필드 생성 완료 . 왜 long인가? 확장성 고려 int보다 좋음

    @Column(length = 16, nullable = false) // 보통 2진수로 데이터 값 나타냄
    private String name;

    @Column(length = 64, nullable = false) //nullable = false > NOTNULL 의미
    private String email;


    @CreatedDate //데이터 생성된 시점 기록하는 자동화 필요
    private LocalDateTime createAt; // 대문자At인 이유 자동으로 대문자 시작부터 _at로 바뀐다

    @LastModifiedDate // 수정 시간 기록
    private LocalDateTime updatedAt; // 최신 클래스

    @Column(columnDefinition="boolean default false")
    private boolean isDeleted;

}
