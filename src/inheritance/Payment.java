package inheritance;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Payment {

    private final String paymentId;

    private final BigDecimal amount;

    private PaymentStatus status;

    protected Payment(String paymentId, BigDecimal amount) {
        validatePaymentId(paymentId);
        validateAmount(amount);

        this.paymentId = paymentId;
        this.amount = amount;
        this.status = PaymentStatus.CREATED;
    }

    // Template method – cannot be overridden
    public final void process() {
        executePayment();
        this.status = PaymentStatus.SUCCESS;
    }

    // Subclasses must implement this
    protected abstract void executePayment();

    public final String getPaymentId() {
        return paymentId;
    }

    public final BigDecimal getAmount() {
        return amount;
    }

    public final PaymentStatus getStatus() {
        return status;
    }

    private void validatePaymentId(String id) {
        Objects.requireNonNull(id, "Payment ID cannot be null");

        if (!id.matches("\\d+")) {
            throw new IllegalArgumentException("Payment ID must be numeric");
        }
    }

    private void validateAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}
