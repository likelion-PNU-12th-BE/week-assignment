package study.likelionbeweekly.week2.manual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.likelionbeweekly.week2.manual.discount.DiscountPolicy;
import study.likelionbeweekly.week2.manual.discount.FixDiscountPolicy;
import study.likelionbeweekly.week2.manual.member.*;
import study.likelionbeweekly.week2.manual.order.OrderService;
import study.likelionbeweekly.week2.manual.order.OrderServicePureJavaImpl;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServicePureJavaImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
