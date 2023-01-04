package flower.flowercontinue.delivery;

public interface Delivery {
    double transitionCosts();

    int getType();
    double deliver(double price);
}
