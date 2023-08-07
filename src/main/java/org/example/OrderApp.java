package org.example;

import org.example.meber.Grade;
import org.example.meber.Member;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.example.order.Order;
import org.example.order.OrderService;
import org.example.order.OrderServiceImpl;

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
