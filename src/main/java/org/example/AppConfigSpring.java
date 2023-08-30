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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSpring {
    // 스프링 기반
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
