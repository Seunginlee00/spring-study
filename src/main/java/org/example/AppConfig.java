package org.example;

import org.example.discount.FixDiscountPolicy;
import org.example.discount.RateDiscountPolicy;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.example.meber.MemoryMemberRepository;
import org.example.order.OrderService;
import org.example.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());  // 생성자 주입!
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy()
        );
    }
}