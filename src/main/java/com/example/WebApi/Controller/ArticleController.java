package com.example.WebApi.Controller;

import com.example.WebApi.Entity.Article;
import com.example.WebApi.Repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
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
    public Article setArticle(@RequestBody String text){
        article = new Article();
        article.setContent("Hallo Content Test");
        article.setId(1);
        article.setHeadline("Headline Test");
        return article;
    }

}
