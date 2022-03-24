package com.rsproject.articlemanagementapi.article;

import jdk.jfr.Enabled;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    private String authors;
    private String abstrct;
    private String article;

    public Article() {
    }

    public Article(String title, String authors, String abstrct, String article) {
        this.title = title;
        this.authors = authors;
        this.abstrct = abstrct;
        this.article = article;
    }

    public Article(Long id, String title, String authors, String abstrct, String article) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.abstrct = abstrct;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAbstrct() {
        return abstrct;
    }

    public void setAbstrct(String abstrct) {
        this.abstrct = abstrct;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", abstrct='" + abstrct + '\'' +
                ", article='" + article + '\'' +
                '}';
    }
}

