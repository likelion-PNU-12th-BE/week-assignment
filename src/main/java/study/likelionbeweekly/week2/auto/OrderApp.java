package study.likelionbeweekly.week2.auto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.likelionbeweekly.week2.auto.member.Grade;
import study.likelionbeweekly.week2.auto.member.Member;
import study.likelionbeweekly.week2.auto.member.MemberService;
import study.likelionbeweekly.week2.auto.order.Order;
import study.likelionbeweekly.week2.auto.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = applicationContext.getBean(MemberService.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order.toString());
        System.out.println(order.calculatePrice());
    }
}
