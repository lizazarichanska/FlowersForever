package flower.flowercontinue.payment;

public interface Payment {
    double fee();
    int getType();

    boolean pay(double price);
}
