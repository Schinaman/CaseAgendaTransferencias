package com.guigo.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guigo.projeto.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
