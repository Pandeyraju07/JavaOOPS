package WalletPayment;

public class CreditCardPayment implements Payment {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public PaymentResult process(double amount) {
        // simulate gateway logic
        return PaymentResult.success("Credit Card Approved");
    }
}

