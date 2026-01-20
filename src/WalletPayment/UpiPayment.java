package WalletPayment;

public class UpiPayment implements Payment {
    private final String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public PaymentResult process(double amount) {
        return PaymentResult.success("UPI Payment Successful");
    }
}

