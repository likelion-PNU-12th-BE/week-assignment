package study.likelionbeweekly.week2.auto.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.likelionbeweekly.week2.auto.discount.DiscountPolicy;
import study.likelionbeweekly.week2.auto.member.Member;
import study.likelionbeweekly.week2.auto.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {


    //필드 주입
    @Autowired private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    //세터 주입
    @Autowired
    public void setDiscountPolicy(@Qualifier("rateDiscountPolicy") DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
