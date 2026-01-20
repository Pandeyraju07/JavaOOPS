package WalletPayment;

public interface Payment {
    PaymentResult process(double amount);
}

