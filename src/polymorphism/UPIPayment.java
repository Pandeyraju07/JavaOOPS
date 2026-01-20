package polymorphism;

public class UPIPayment extends Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
        System.out.println("Redirecting to UPI gateway...");
    }
}
