package com.codeup.spring_blog.Repositories;

import com.codeup.spring_blog.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    Post findFirstByTitle(String title);
}
