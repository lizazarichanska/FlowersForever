package flower.flowercontinue.payment;

public class CreditCardPayment implements Payment {
    @Override
    public double fee() {
        return 0.25;
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public boolean pay(double price) {
        double balance = price*2;
        price *= fee();
        if (price <= balance) {
            balance = balance - price;
            return true;
        }
        return false;
    }

}
