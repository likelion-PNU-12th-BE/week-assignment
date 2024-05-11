package study.likelionBEweekly.week2.manual;

import study.likelionBEweekly.week2.manual.discount.DiscountPolicy;
import study.likelionBEweekly.week2.manual.discount.FixDiscountPolicy;
import study.likelionBEweekly.week2.manual.member.MemberRepository;
import study.likelionBEweekly.week2.manual.member.MemberService;
import study.likelionBEweekly.week2.manual.member.MemberServicePureJavaImpl;
import study.likelionBEweekly.week2.manual.member.MemoryMemberRepository;
import study.likelionBEweekly.week2.manual.order.OrderService;
import study.likelionBEweekly.week2.manual.order.OrderServicePureJavaImpl;

public class PureJavaAppConfig {

    public MemberService memberService(){
        return new MemberServicePureJavaImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServicePureJavaImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
