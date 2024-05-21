package study.likelionbeweekly.week2.manual.discount;

import study.likelionbeweekly.week2.manual.member.Grade;
import study.likelionbeweekly.week2.manual.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }
        return 0;
    }
}
