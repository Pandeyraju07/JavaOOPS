package interfaces;

import java.math.BigDecimal;

public final class UpiPayment implements PaymentMethod {

    private final String upiId;

    public UpiPayment(String upiId) {
        if (!upiId.contains("@")) {
            throw new IllegalArgumentException("Invalid UPI ID");
        }
        this.upiId = upiId;
    }

    @Override
    public void pay(String paymentId, BigDecimal amount) {
        System.out.println(
                "UPI payment processed for " + upiId +
                        ", Amount: " + amount
        );
    }
}
