package WalletPayment;

public class OrderService {

    public void processOrder(Order order, Payment payment) {
        order.attachPayment(payment);

        PaymentResult result = payment.process(order.getAmount());

        if (result.isSuccess()) {
            order.markPaid();
        } else {
            throw new IllegalStateException("Payment Failed");
        }
    }
}

