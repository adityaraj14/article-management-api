package com.rsproject.articlemanagementapi.service;

import com.rsproject.articlemanagementapi.model.Article;
import com.rsproject.articlemanagementapi.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagementService {

    private final ArticleRepo articleRepo;

    @Autowired
    public ArticleManagementService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public Article addArticle(Article article) {
        return articleRepo.save(article);
    }

    public List<Article> findAllArticles() {
        return articleRepo.findAll();
    }

    public Article updateArticle(Article article) {
        return articleRepo.save(article);
    }

    public void deleteArticle(Long id) {
        articleRepo.deleteArticleById(id);
    }

}
