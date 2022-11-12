package com.codeup.spring_blog.Entities;


import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //long is used as it an adequate replacement for an unsigned integer but
    //it is not truly unsigned and is capable of negative integers its just as capable of
    //reaching the same size as a regular unsigned int
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = true, length = 500)
    private String description;

    @Column(nullable = false, length = 1000)
    private String content;

}
