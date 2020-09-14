package com.example.WebApi.Controller;

import com.example.WebApi.Entity.Article;
import com.example.WebApi.Repository.ArticleRepository;
import com.example.WebApi.Services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    ArticleService articleService;

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable String id){
        return articleService.getArticle(id);
    }

    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public List<Article> getArticleAll(){
        return articleService.getArticleAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void setArticle(@RequestBody Article newArticle){
        articleService.saveArticle(newArticle);
    }

    @RequestMapping(value = "/edit/{id}" , method = RequestMethod.PUT)
    public ResponseEntity editArticle(@PathVariable String id, @RequestBody Article newArticle){
        return articleService.editArticle(id, newArticle);
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable String id){
        articleService.deleteArticle(id);
    }

    @RequestMapping(value ="delete/all", method = RequestMethod.DELETE)
    public void deleteAllArticles(){
        articleService.deleteAllArticles();
    }

    @RequestMapping(value = "/edit/headline/{id}", method = RequestMethod.PATCH)
    public ResponseEntity editHeadline(@PathVariable String id, @RequestBody String headline){
        return articleService.editHeadline(id, headline);
    }

}
