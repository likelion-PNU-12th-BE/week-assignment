package study.likelionbeweekly.week2.manual;

import study.likelionbeweekly.week2.manual.member.Grade;
import study.likelionbeweekly.week2.manual.member.Member;
import study.likelionbeweekly.week2.manual.member.MemberService;
import study.likelionbeweekly.week2.manual.order.Order;
import study.likelionbeweekly.week2.manual.order.OrderService;

public class PureJavaOrderApp {
    public static void main(String[] args) {
        PureJavaAppConfig appConfig = new PureJavaAppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println(order.toString());
        System.out.println(order.calculatePrice());
    }
}
