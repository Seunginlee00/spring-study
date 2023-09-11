package org.example.member;

import org.assertj.core.api.Assertions;
import org.example.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }

    // 지금 코드는 DI를 위반 하고 있음
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        // 녹색불이 떠야 대여,, 그러면 기분이가 조커든요..
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
