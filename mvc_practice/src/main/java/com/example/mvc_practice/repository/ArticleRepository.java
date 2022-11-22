package com.example.mvc_practice.repository;

import com.example.mvc_practice.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
//상속 받은 것 인터페이스므로 껍데기밖에 없음
