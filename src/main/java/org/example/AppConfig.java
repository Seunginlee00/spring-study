package org.example;

import org.example.discount.DiscountPolicy;
import org.example.discount.FixDiscountPolicy;
import org.example.discount.RateDiscountPolicy;
import org.example.meber.MemberRepository;
import org.example.meber.MemberService;
import org.example.meber.MemberServiceImpl;
import org.example.meber.MemoryMemberRepository;
import org.example.order.OrderService;
import org.example.order.OrderServiceImpl;
// 자바 기반 소스 코드
public class AppConfig {
    //애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    public MemberRepository memberRepository() {
        // 변경이 있을시 return 값만 바꿔주면 됨
        return new MemoryMemberRepository();
    }
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}