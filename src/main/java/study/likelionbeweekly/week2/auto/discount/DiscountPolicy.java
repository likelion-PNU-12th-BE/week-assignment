package study.likelionbeweekly.week2.auto.discount;

import study.likelionbeweekly.week2.auto.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
