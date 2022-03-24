package com.rsproject.articlemanagementapi;

import com.rsproject.articlemanagementapi.model.Article;
import com.rsproject.articlemanagementapi.service.ArticleManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ArticleManagementController {

    private final ArticleManagementService articleMgmtService;

    @Autowired
    public ArticleManagementController(ArticleManagementService articleMgmtService) {
        this.articleMgmtService = articleMgmtService;
    }

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getALlArticles() {
        List<Article> articles = articleMgmtService.findAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        Article add_article = articleMgmtService.addArticle(article);
        return new ResponseEntity<>(add_article, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        Article update_article = articleMgmtService.updateArticle(article);
        return new ResponseEntity<>(update_article, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id) {
        articleMgmtService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
