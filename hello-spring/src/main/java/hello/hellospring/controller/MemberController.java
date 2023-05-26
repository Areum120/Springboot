package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;//기능이 많지 않아서 인스턴스 하나만 생성해도 됨

    @Autowired
    public MemberController(MemberService memberService) {//컴포넌트 스캔 방식 :memberService에 @Service 붙여줌, MemoryMemberRepository 에 @Repository 붙여줌, memberService 생성자에 @Autowired 붙여줌
        this.memberService = memberService;
    }
}
