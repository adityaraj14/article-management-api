package com.rsproject.articlemanagementapi.repo;

import com.rsproject.articlemanagementapi.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
    void deleteArticleById(Long id);
}
