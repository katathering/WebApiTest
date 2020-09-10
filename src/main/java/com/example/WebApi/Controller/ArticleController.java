package com.example.WebApi.Controller;

import com.example.WebApi.Entity.Article;
import com.example.WebApi.Repository.ArticleRepository;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;
    Article article;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Article getArticle(){
         String headline  = "Eine Überschrift";
         String content = "balablablablablabal";

        Article article = new Article(headline, content);
        return article;
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public List<Article> getArticleAll(){
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String setArticle(@RequestBody String text){
//        article.setContent("hallo");
//        String headline  = "Eine Überschrift";
//        String content = "balablablablablabal";
        return text;
    }

}
