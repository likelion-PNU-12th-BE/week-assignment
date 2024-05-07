package study.likelionBEweekly.week2.manual.discount;

import study.likelionBEweekly.week2.manual.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
