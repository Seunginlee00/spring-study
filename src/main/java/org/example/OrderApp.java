package org.example;

import org.example.member.Grade;
import org.example.member.Member;
import org.example.member.MemberService;
import org.example.order.Order;
import org.example.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000);
        System.out.println("order = "+ order);
        System.out.println("orders =" + order.getDiscountPrice());
    }
}
