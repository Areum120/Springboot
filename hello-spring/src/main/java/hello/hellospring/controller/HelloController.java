package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";//hello.html로 가라는 것
    }


    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {//외부에서 파라미터 받기
        model.addAttribute("name", name);//파라미터로 넘어온 name 넘기기
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody//http의 body부에 data를 직접 넣어주겠다라는 내용, ViewResolver를 사용하지 않음
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;//html없이 그대로 받은 파라미터를 넣어버림
    }


    @GetMapping("hello-api")
    @ResponseBody//객체를 반환하면 json방식으로 data 전달
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }


}
