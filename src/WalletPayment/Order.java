package WalletPayment;

public class Order {

    private final String orderId;
    private OrderStatus status;
    private final double amount;
    private Payment payment;

    public Order(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = OrderStatus.CREATED;
    }

    public void attachPayment(Payment payment) {
        this.payment = payment;
    }

    public void markPaid() {
        this.status = OrderStatus.PAID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }
}
