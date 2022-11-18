package com.codeup.spring_blog.repositories;

import com.codeup.spring_blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    }
