package com.example.mvc_practice.domain.dto;

import com.example.mvc_practice.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleDto {

    private String title;
    private String content;

    //비즈니스 로직은 dto
    public Article toEntity(){//저장하는 data와 실제로 돌아가는 data를 따로 만들어줘야 함, db에 저장하거나, db관련 저장할 때, select 쓰는 게 entity, 분리를 안해주면 확장성에 문제가 생김
        return new Article(title, content);
    }



}
