package org.example;
import org.example.discount.DiscountPolicy;
import org.example.discount.RateDiscountPolicy;
import org.example.member.MemberRepository;
import org.example.member.MemberService;
import org.example.member.MemberServiceImpl;
import org.example.member.MemoryMemberRepository;
import org.example.order.OrderService;
import org.example.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigSpring {
    // 스프링 기반

    //해당 소스코드에서는 memberService 에서 memberrepo 1번
    // orderservice 에서 두번.. 싱글톤이 깨지는가..?
    //soutm -> 해당 메소드 출력


    // call AppConfigSpring.memberService
    //call AppConfigSpring.memberRepository -> 한번만 출력됨 ..???

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfigSpring.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfigSpring.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfigSpring.memberRepository");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
