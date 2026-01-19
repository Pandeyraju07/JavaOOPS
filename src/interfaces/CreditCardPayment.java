package interfaces;


import java.math.BigDecimal;
import java.util.Objects;

public final class CreditCardPayment implements PaymentMethod {

    private final String maskedCardDigits;

    public CreditCardPayment(String maskedCardDigits) {
        if (!maskedCardDigits.matches("\\d{4}")) {
            throw new IllegalArgumentException("Invalid card digits");
        }
        this.maskedCardDigits = maskedCardDigits;
    }

    @Override
    public void pay(String paymentId, BigDecimal amount) {
        Objects.requireNonNull(amount);

        System.out.println(
                "Credit Card payment processed. Card ****" + maskedCardDigits +
                        ", Amount: " + amount
        );
    }
}

