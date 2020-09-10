package com.example.WebApi.Entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {

    private String headline;
    private String content;
    private Integer id;

    public Article(){

    }

    public Article(String headline, String content ) {
        this.headline = headline;
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }
}
