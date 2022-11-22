package com.example.evsa_backend.service;
import com.example.evsa_backend.dto.Info;
import org.springframework.stereotype.Service;

@Service//controller에 반환되는 비즈니스 로직임을 명시한다
public class TestService {

    public String myName(String name){
        if (name != null) {
            return "my name is" + name;
        }else {
            return "no name param";
        }
    }

    public String myAge(Integer age){
        if (age != null) {
         return "my age is" + age;
        }else {
            return "no age param";
        }
    }

    public String myInfo(Info info){
        return myName(info.getName())+" / "+myAge(info.getAge());

    }

    public String myInfoWithRole(String role, Info info){
        return role + " / "+ myInfo(info);
    }
}

