package interfaces;


import java.math.BigDecimal;


public interface PaymentMethod {

    void pay(String paymentId, BigDecimal amount);
}

