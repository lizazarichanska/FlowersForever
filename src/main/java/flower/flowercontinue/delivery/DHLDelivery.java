package flower.flowercontinue.delivery;

public class DHLDelivery implements Delivery {
    @Override
    public double transitionCosts() {
        return 0.05;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public double deliver(double price) {
        return (price*(1+transitionCosts()));
    }
}
