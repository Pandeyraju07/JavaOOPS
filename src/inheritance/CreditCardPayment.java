package inheritance;

import java.math.BigDecimal;

public final class CreditCardPayment extends Payment {

    private final String maskedCardNumber;

    public CreditCardPayment(String paymentId,
                             BigDecimal amount,
                             String maskedCardNumber) {

        super(paymentId, amount);

        if (!maskedCardNumber.matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid card number");
        }
        this.maskedCardNumber = maskedCardNumber;
    }

    @Override
    protected void executePayment() {
        System.out.println("Processing credit card payment ending with "
                + maskedCardNumber);
    }
}

