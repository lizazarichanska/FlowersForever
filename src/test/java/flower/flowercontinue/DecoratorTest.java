package flower.flowercontinue;

import flower.flowercontinue.decorator.PaperDecorator;
import flower.flowercontinue.decorator.RibbonDecorator;
import flower.flowercontinue.flower.Flower;
import flower.flowercontinue.flower.FlowerColor;
import flower.flowercontinue.flower.FlowerType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecoratorTest {
    private Flower tulip;
    private RibbonDecorator ribbon;
    private PaperDecorator paper;
    @BeforeEach
    public void init() {
        tulip = new Flower(2.4, FlowerColor.WHITE, 23.4, FlowerType.TULIP);
        ribbon = new RibbonDecorator();
        paper = new PaperDecorator();
    }

    @Test
    public void testRibbonDecorator() {
        double orderPrice = ribbon.decorate(tulip);
        Assertions.assertEquals(orderPrice, ribbon.decorate(tulip));
    }

    @Test
    public void testPaperDecorator() {
        double orderPrice = paper.decorate(tulip);
        Assertions.assertEquals(orderPrice, paper.decorate(tulip));
    }
}
