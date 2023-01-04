package flower.flowercontinue;

import flower.flowercontinue.flower.Flower;
import flower.flowercontinue.flower.FlowerColor;
import flower.flowercontinue.flower.FlowerType;
import flower.flowercontinue.order.Order;
import flower.flowercontinue.payment.PayPalPayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    private Order order;
    private PayPalPayment payment;
    private Flower flowerOne;
    private Flower flowerTwo;


    @BeforeEach
    public void init() {
        flowerOne = new Flower(2.4, FlowerColor.WHITE,
                23.4, FlowerType.TULIP);
        flowerTwo = new Flower(8, FlowerColor.BLUE,
                40.6, FlowerType.CHAMOMILE);
        payment = new PayPalPayment();
        order = new Order();
        order.addFlower(flowerOne);
        order.addFlower(flowerTwo);
    }

    @Test
    public void testOrder() {
        Assertions.assertEquals(
                flowerOne.getPrice()+ flowerTwo.getPrice(),
                order.totalPrice());
    }

    @Test
    public void testPayment() {
        order.setPayment(payment);
        Assertions.assertEquals(payment, order.getPayment());
        boolean payForFlowerOne = payment.pay(flowerOne.getPrice());
        Assertions.assertEquals(true, payForFlowerOne);
    }
}
