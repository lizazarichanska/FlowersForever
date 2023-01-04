package flower.flowercontinue.decorator;

import flower.flowercontinue.item.Item;

public class RibbonDecorator implements AbstractDecorator {
    @Override
    public double decorate(Item flower) {
        return 6 + flower.getPrice();
    }
}
