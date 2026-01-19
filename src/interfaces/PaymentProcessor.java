package interfaces;

import java.math.BigDecimal;
import java.util.Objects;

public final class PaymentProcessor {

    private final PaymentMethod paymentMethod;
    private final NotificationService notificationService;

    public PaymentProcessor(PaymentMethod paymentMethod,
                            NotificationService notificationService) {

        this.paymentMethod = Objects.requireNonNull(paymentMethod);
        this.notificationService = Objects.requireNonNull(notificationService);
    }

    public void process(String paymentId, BigDecimal amount) {
        paymentMethod.pay(paymentId, amount);
        notificationService.notify(
                "Payment " + paymentId + " successful for amount " + amount
        );
    }
}

