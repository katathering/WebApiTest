package com.example.WebApi.Services;

import com.example.WebApi.Entity.Article;
import com.example.WebApi.Repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.EmptyStackException;
import java.util.List;

@Service
public class ArticleService {
    @Resource
    ArticleRepository articleRepository;

    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> getArticleAll(){
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    public Article getArticle(String id) {
        boolean article = articleRepository.findById(id).isPresent();
        if (article) {
            return articleRepository.findById(id).get();
        }else{
            throw new EmptyStackException();
        }
    }

    public void deleteArticle(String id) {
        boolean isArticle = articleRepository.findById(id).isPresent();
        if (isArticle) {
            Article article = articleRepository.findById(id).get();
            articleRepository.delete(article);
        }else{
            throw new EmptyStackException();
        }
    }

    public ResponseEntity editArticle(String id, Article newArticle) {
        boolean isArticle = articleRepository.findById(id).isPresent();
        if (isArticle) {
            Article article = articleRepository.findById(id).get();
            article.setHeadline(newArticle.getHeadline());
            article.setContent(newArticle.getContent());
            articleRepository.save(article);
            return  ResponseEntity.status(HttpStatus.OK).body("Article edited!");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Article not found!");
        }
    }

    public void deleteAllArticles() {
        articleRepository.deleteAll();
    }

    public ResponseEntity editHeadline(String id, String headline) {
        boolean isArticle = articleRepository.findById(id).isPresent();
        if (isArticle){
            Article article = articleRepository.findById(id).get();
            article.setHeadline(headline);
            articleRepository.save(article);

            return  ResponseEntity.status(HttpStatus.OK).body("Headline changed!");
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Article not found!");
        }

    }
}
