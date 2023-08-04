package org.example;

import org.example.meber.Grade;
import org.example.meber.Member;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;

public class Main {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        // commend option v
        // ctrl + alt + v
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = "+ findMember.getName());
    }
}