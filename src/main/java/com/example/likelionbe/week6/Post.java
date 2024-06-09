package com.example.likelionbe.week6;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Post {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "content")
    private String content;
    @Column(name = "img")
    private String img;
    @Column(name = "like")
    private int like;
    @Column(name = "member_id")
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member_id;
    public Post( String content,String imd,Member id)
    {

        this.content =content;
        this.img =img;
        member_id = id;
    }
}
