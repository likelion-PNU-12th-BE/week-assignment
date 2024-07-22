package study.likelionbeweekly.week6.posts;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import study.likelionbeweekly.week6.comment.Comment;
import study.likelionbeweekly.week6.member.Member;
@Data
@Entity

public class Posts {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long num;
       private String content;
       private String img;
       private Long count_like;

       @ManyToOne
       @JoinColumn(name = "user_id")
       private Member member;

       @OneToMany(mappedBy = "posts")
       private List<Comment> comment;

        public Posts() {}

}
