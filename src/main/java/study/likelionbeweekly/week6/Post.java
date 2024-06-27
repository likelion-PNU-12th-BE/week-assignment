package study.likelionbeweekly.week6;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PostID;

    @Column(name = "Post_title", nullable = true)
    private String title;

    @Column(name = "Post_content", nullable = true)
    private String content;

    @Column(name = "Post_likes", nullable = false)
    private int likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID", nullable = false)
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade =  CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();
}
