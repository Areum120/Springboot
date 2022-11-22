package com.example.mvc_practice.controller;

import com.example.mvc_practice.domain.Article;
import com.example.mvc_practice.domain.dto.ArticleDto;
import com.example.mvc_practice.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j//로그찍는 것
class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String createArticlePage() {
        return "new";
    }

    @PostMapping("")
    public String createArticle(ArticleDto articleDto) {

        Article savedAricle = articleRepository.save(articleDto.toEntity());//article을 return해줌, repository를 만들면 save 기능이 스프링부트가 di를 해줌(dependancy injection) data를 입력해줌
        return String.format("id:%d", savedAricle.getId());//ID가 long이라서 에러가 나서 String.format 사용해줌

    }
}