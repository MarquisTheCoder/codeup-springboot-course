package com.codeup.spring_blog.Entities;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
/* THE ABOVE ENTITY EQUALS
* CREATE TABLE ads (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
* */