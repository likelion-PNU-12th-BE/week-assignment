package study.likelionBEweekly.week2.manual.discount;

import study.likelionBEweekly.week2.manual.member.Grade;
import study.likelionBEweekly.week2.manual.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
