package study.likelionBEweekly.week2.auto.discount;

import study.likelionBEweekly.week2.auto.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
