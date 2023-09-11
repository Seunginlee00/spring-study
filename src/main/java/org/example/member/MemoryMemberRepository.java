package org.example.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
// 수동빈이 자동빈을 오버라이드함. 해당 메세지가 출력됨
// 스프링부트가 기본적으로 오버라이드를 false값으로 되어 있음...
// 사용하려면  해당값을 true해주는 설정이 들어가야함
// 애매한 상황을 피하기 위해서

@Component //memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); // 동시성 이슈가 있을 수 있음.. 실무에서는 주의 해야함
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
