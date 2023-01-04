package flower.flowercontinue.decorator;

import flower.flowercontinue.item.Item;

public class PaperDecorator implements AbstractDecorator{
    @Override
    public double decorate(Item flower) {
        return 12 + flower.getPrice();
    }
}
