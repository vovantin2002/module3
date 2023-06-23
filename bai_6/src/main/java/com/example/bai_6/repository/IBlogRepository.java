package com.example.bai_6.repository;

import com.example.bai_6.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from blogs as b where b.title like concat('%',:title,'%') ", nativeQuery = true)
    Page<Blog> findAllByTitle(Pageable pageable, @Param(value = "title") String title);
}
