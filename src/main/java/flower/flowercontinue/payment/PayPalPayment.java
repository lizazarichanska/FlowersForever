package flower.flowercontinue.payment;

public class PayPalPayment implements Payment {

    @Override
    public double fee() {
        return 0.1;
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public boolean pay(double price) {
        double balance = price*2;
        double fee = fee();
        price = price*fee;
        if (price <= balance) {
            return true;
        }
        return false;
    }
}
