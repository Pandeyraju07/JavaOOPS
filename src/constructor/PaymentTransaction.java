package constructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

public final class PaymentTransaction {

    private static final Set<String> SUPPORTED_CURRENCIES =
            Set.of("INR", "USD", "EUR");

    private final String transactionId;
    private final BigDecimal amount;
    private final String currency;
    private final Instant createdAt;

    public PaymentTransaction(String transactionId,
                              BigDecimal amount,
                              String currency) {

        validateTransactionId(transactionId);
        validateAmount(amount);
        validateCurrency(currency);

        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.createdAt = Instant.now();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    /* ================= Validation ================= */

    private void validateTransactionId(String id) {
        Objects.requireNonNull(id, "Transaction ID cannot be null");

        if (!id.matches("\\d{12}")) {
            throw new IllegalArgumentException(
                    "Transaction ID must be exactly 12 digits"
            );
        }
    }

    private void validateAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }
    }

    private void validateCurrency(String currency) {
        Objects.requireNonNull(currency, "Currency cannot be null");

        if (!SUPPORTED_CURRENCIES.contains(currency)) {
            throw new IllegalArgumentException(
                    "Unsupported currency: " + currency
            );
        }
    }
}
