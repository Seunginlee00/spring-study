package org.example.discount;

import org.example.member.Member;

public interface DiscountPolicy {
    // 대신 주입 시켜주는 대상이 있어야한다.
    // return 할인 대상 금액
    int discount(Member member, int price);
}
