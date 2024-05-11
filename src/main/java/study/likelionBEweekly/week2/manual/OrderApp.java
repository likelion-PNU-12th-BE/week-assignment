package study.likelionBEweekly.week2.manual;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.likelionBEweekly.week2.manual.member.Grade;
import study.likelionBEweekly.week2.manual.member.Member;
import study.likelionBEweekly.week2.manual.member.MemberService;
import study.likelionBEweekly.week2.manual.order.Order;
import study.likelionBEweekly.week2.manual.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService" , MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order.toString());
        System.out.println(order.calculatePrice());
    }
}
