package com.example.likelionbe.week6;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "date")
    String date;
    @Column(name = "content")
    String content;
    @Column(name = "post_id")
    @ManyToOne
    @JoinColumn(name = "Post_id")
    Post post_id;
    @Column(name = "member_id")
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;
    public Comment(String name,String content,Member member_id)
    {
        this.name = name;
        this.content = content;
        this.member_id = member_id;
    }
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}
