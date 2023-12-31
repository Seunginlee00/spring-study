package org.example.discount;

import org.example.annotation.MainDiscountPolicy;
import org.example.member.Grade;
import org.example.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10% 할인 @Override
// commend + shfit + t
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            // 이런식의 계산은 주의 해야함..
            return price * discountPercent /  100;
        } else {
            return 0;
        }
    }
}