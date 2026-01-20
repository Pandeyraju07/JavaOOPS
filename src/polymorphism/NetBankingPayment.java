package polymorphism;

public class NetBankingPayment extends Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Net Banking payment of ₹" + amount);
        System.out.println("Redirecting to bank portal...");
    }
}
