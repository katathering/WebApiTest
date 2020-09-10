package com.example.WebApi.Services;

import com.example.WebApi.Entity.Article;
import com.example.WebApi.Repository.ArticleRepository;
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

    public Article getArticle(Integer id) {
        boolean article = articleRepository.findById(id).isPresent();
        if (article) {
            return articleRepository.findById(id).get();
        }else{
            throw new EmptyStackException();
        }

    }

    public void deleteArticle(Integer id) {
        boolean isArticle = articleRepository.findById(id).isPresent();
        if (isArticle) {
            Article article = articleRepository.findById(id).get();
            articleRepository.delete(article);
        }else{
            throw new EmptyStackException();
        }
    }

    public void editArticle(Integer id, Article newArticle) {
        boolean isArticle = articleRepository.findById(id).isPresent();
        if (isArticle) {
            articleRepository.save(newArticle);
        }else{
            throw new EmptyStackException();
        }
    }
}