package com.example.WebApi.Repository;

import com.example.WebApi.Entity.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository  extends MongoRepository<Article, Integer> {

}

