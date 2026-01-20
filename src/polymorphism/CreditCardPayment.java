package polymorphism;

public class CreditCardPayment extends Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount);
        System.out.println("Validating card details...");
        System.out.println("Charging card...");
    }
}
