package study.likelionbeweekly.week2.manual.discount;

import study.likelionbeweekly.week2.manual.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
