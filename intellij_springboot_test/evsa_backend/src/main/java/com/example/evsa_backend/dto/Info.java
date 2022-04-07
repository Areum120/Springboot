package com.example.evsa_backend.dto;//Request Body의 model을 만들기 위해 dto 디렉토리, info 모델 생성
import lombok.Data;

@Data//Lombok에서 제공하는 annotation으로 getter와 setter 생성해줌
public class Info {
    String name;
    Integer age;
}
