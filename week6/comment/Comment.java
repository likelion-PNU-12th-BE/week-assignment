package study.likelionbeweekly.week6.comment;

import jakarta.persistence.*;
import lombok.Data;
import study.likelionbeweekly.week6.posts.Posts;
@Data
@Entity
public class Comment {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long com_id;
      private String comment;
      private Long com_like;

      @ManyToOne
      @JoinColumn(name = "posts_num")
      private Posts posts;
      public Comment() {}
}