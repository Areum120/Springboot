package com.example.mvc_practice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//data가 들어갈 table을 만드는 것

@Entity
@Getter
@Table(name = "article3")//table name 지정
@NoArgsConstructor//모든 컬럼을 초기화하는 생성자가 없을 때 사용함 (jpa를 쓸 때 id를 반드시 넣어줘야 하는데 arguement가 없는,,즉 id를 받는게 없어서 빈 arguement를 생성해야함
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//db에 id 생성을 맡김
    private Long id;//jpa가 id를 자동으로 만들어주기 대문에 인스턴스를 안받음
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
