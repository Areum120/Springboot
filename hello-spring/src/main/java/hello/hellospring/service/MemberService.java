package hello.hellospring.service;
//비즈니스 로직

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입

    public Long join(Member member){

        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);//통과하면 저장
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        //같은 이름이 있는 중복 회원x
        Optional<Member> result = memberRepository.findByName(member.getName());
        //이름 검색기능으로 같은 이름이 있으면
        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
      public List<Member> findMembers(){//모두 찾기
        return memberRepository.findAll();
      }

      public Optional<Member> findOne(Long memberId) {//검색 일치하는 회원 찾기
        return memberRepository.findById(memberId);
      }




      
}
