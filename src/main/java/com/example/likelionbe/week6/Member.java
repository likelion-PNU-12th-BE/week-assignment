package com.example.likelionbe.week6;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;


    public Member(int id,String password)
    {
        this.id = id;
        this.password =password;
    }
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }
    public void CreatePost(String content, String img)
    {
        Post post = new Post(content,img,this);
    }
    public void CreateCommente(String content)
    {
        Comment comment = new Comment(this.name,content,this);
    }
}
