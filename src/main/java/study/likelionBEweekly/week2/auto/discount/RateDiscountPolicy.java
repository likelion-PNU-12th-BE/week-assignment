package study.likelionBEweekly.week2.auto.discount;

import org.springframework.stereotype.Component;
import study.likelionBEweekly.week2.auto.member.Grade;
import study.likelionBEweekly.week2.auto.member.Member;

@Component
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
