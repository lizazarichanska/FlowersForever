package flower.flowercontinue;

import flower.flowercontinue.delivery.DHLDelivery;
import flower.flowercontinue.flower.Flower;
import flower.flowercontinue.flower.FlowerColor;
import flower.flowercontinue.flower.FlowerType;
import flower.flowercontinue.order.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeliveryTest {
    private Order order;
    private DHLDelivery delivery;
    private Flower flowerOne;
    private Flower flowerTwo;


    @BeforeEach
    public void init() {
        double sepalLength = 2.4;
        double price = 40.0;
        flowerOne = new Flower(sepalLength, FlowerColor.WHITE,
                price, FlowerType.TULIP);
        flowerTwo = new Flower(sepalLength, FlowerColor.BLUE,
                price, FlowerType.CHAMOMILE);
        delivery = new DHLDelivery();
        order = new Order();
        order.addFlower(flowerOne);
        order.addFlower(flowerTwo);
    }

    @Test
    public void testOrder() {
        Assertions.assertEquals(flowerOne.getPrice()+ flowerTwo.getPrice(),
                order.totalPrice());
    }

    @Test
    public void testDelivery() {
        order.setDelivery(delivery);
        Assertions.assertEquals(delivery, order.getDelivery());
        double deliverFlowerOne = delivery.deliver(flowerOne.getPrice());
        Assertions.assertEquals(
                (1+delivery.transitionCosts())*flowerOne.getPrice(),
                deliverFlowerOne);
    }
}
