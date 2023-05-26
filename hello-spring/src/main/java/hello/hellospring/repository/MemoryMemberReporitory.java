package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberReporitory implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;//0,1,2key값 생성


    @Override
    public Member save(Member member) {
        member.setId(++sequence);//값 올려주기
        store.put(member.getId(), member);//store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//null값 나와도 반환가능
        }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()//멤버들 반환
                .filter(member -> member.getName().equals(name))//이름 검색 시
                .findAny();//루프로 돌면서 하나 찾으면 반환
    }

    @Override
    public List<Member> findAll() {//반환은 list로 쓰기
        return new ArrayList<>(store.values());//store에 있는 멤버들 반환해주기
    }

    public void clearStore(){
        store.clear();}


}
