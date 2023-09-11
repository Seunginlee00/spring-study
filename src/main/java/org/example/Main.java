package org.example;

import org.example.member.Grade;
import org.example.member.Member;
import org.example.member.MemberService;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService();
        // commend option v
        // ctrl + alt + v
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}