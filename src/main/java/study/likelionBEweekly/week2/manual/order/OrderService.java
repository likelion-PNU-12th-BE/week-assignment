package study.likelionBEweekly.week2.manual.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
