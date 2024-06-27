package study.likelionbeweekly.week6.member;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import study.likelionbeweekly.week6.posts.Posts;
@Data
// lombok
// -여러가지 @어노테이션을 제공하고 컴파일 과정에서 자동으로 개발자가 원하는 메소드를 생성/주입 방식으로 동작하는 라이브러리
@Entity

public class Member {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String name;
      private String email;
      private String password;
      private String nick;

      @OneToMany(mappedBy = "member")
      private List<Posts> posts;

      public Member() {}
}
