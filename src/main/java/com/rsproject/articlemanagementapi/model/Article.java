package com.rsproject.articlemanagementapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String title;
    @ElementCollection(targetClass=String.class)
    private List<String> authors;
    private String abstrct;
    private String article;
    private Boolean approved = false;

    public Article() {
    }

    public Article(String title, List<String> authors, String abstrct, String article) {
        this.title = title;
        this.authors = authors;
        this.abstrct = abstrct;
        this.article = article;
    }

    public Article(Long id, String title, List<String> authors, String abstrct, String article, Boolean approved) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.abstrct = abstrct;
        this.article = article;
        this.approved = approved;
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

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", abstrct='" + abstrct + '\'' +
                ", article='" + article + '\'' +
                ", approved=" + approved +
                '}';
    }
}

