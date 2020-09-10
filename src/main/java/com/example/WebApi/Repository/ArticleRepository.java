package com.example.WebApi.Repository;

import com.example.WebApi.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}

