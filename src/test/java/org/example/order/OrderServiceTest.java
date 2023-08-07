package org.example.order;

import org.assertj.core.api.Assertions;
import org.example.AppConfig;
import org.example.meber.Grade;
import org.example.meber.Member;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.example.order.Order;
import org.example.order.OrderService;
import org.example.order.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
