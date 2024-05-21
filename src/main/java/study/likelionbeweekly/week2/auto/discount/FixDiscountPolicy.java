package study.likelionbeweekly.week2.auto.discount;

import org.springframework.stereotype.Component;
import study.likelionbeweekly.week2.auto.member.Grade;
import study.likelionbeweekly.week2.auto.member.Member;

@Component
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
