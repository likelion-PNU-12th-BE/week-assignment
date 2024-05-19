package study.likelionbeweekly.week2.manual;

import study.likelionbeweekly.week2.manual.discount.DiscountPolicy;
import study.likelionbeweekly.week2.manual.discount.FixDiscountPolicy;
import study.likelionbeweekly.week2.manual.member.MemberRepository;
import study.likelionbeweekly.week2.manual.member.MemberService;
import study.likelionbeweekly.week2.manual.member.MemberServicePureJavaImpl;
import study.likelionbeweekly.week2.manual.member.MemoryMemberRepository;
import study.likelionbeweekly.week2.manual.order.OrderService;
import study.likelionbeweekly.week2.manual.order.OrderServicePureJavaImpl;

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
