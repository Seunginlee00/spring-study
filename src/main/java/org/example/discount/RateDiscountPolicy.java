package org.example.discount;

import org.example.meber.Grade;
import org.example.meber.Member;
import org.springframework.stereotype.Component;

@Component
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