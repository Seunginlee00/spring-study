package org.example;

import org.example.meber.Grade;
import org.example.meber.Member;
import org.example.meber.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberAppSpring {
    public static void main(String[] args) {
        // appconfig 에 어너테이션 기반으로 설정된 것들이 적용이 됨
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigSpring.class);
        // 해당 서비스를 등록, 자동적으로 config에서 설정한 이름으로 돌아감
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find member = "+ findMember.getName());


    }
}
