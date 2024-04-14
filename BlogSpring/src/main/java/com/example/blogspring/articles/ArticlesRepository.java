package com.example.blogspring.articles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<ArticleEntity, Long> {
    ArticleEntity findBySlug(String slug);
}
