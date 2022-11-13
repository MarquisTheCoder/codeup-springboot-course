package com.codeup.spring_blog.Repositories;

import com.codeup.spring_blog.Entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    }
