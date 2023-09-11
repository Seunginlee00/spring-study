package org.example;

import org.example.member.Grade;
import org.example.member.Member;
import org.example.member.MemberService;
import org.example.order.Order;
import org.example.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderAppSpring {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigSpring.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000);
        System.out.println("order = "+ order);
        System.out.println("orders =" + order.getDiscountPrice());
    }
}
