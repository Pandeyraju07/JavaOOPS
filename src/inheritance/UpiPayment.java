package inheritance;

import java.math.BigDecimal;

public final class UpiPayment extends Payment {

    private final String upiId;

    public UpiPayment(String paymentId,
                      BigDecimal amount,
                      String upiId) {

        super(paymentId, amount);

        if (!upiId.contains("@")) {
            throw new IllegalArgumentException("Invalid UPI ID");
        }
        this.upiId = upiId;
    }

    @Override
    protected void executePayment() {
        System.out.println("Processing UPI payment for " + upiId);
    }
}

