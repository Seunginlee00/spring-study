package org.example.member;

import org.assertj.core.api.Assertions;
import org.example.meber.Grade;
import org.example.meber.Member;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();
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
