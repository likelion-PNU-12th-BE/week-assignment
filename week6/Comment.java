package study.likelionbeweekly.week6;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Comment_id;

    private String Content;
    private LocalDateTime CreatedDate;

    @ManyToOne
    private Member members;

    @ManyToOne
    private Post posts;

}
