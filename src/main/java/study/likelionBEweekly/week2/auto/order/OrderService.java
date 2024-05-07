package study.likelionBEweekly.week2.auto.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
