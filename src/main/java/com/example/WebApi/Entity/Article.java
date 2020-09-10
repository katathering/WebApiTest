package com.example.WebApi.Entity;

import org.springframework.data.annotation.Id;


public class Article {

    @Id
    private Integer id;
    private String headline;
    private String content;

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

    public Integer getId() {
        return id;
    }
}
