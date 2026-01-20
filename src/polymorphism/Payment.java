package polymorphism;

public abstract class Payment {

    public abstract void processPayment(double amount);

    public void generateReceipt(double amount) {
        System.out.println("Receipt generated for amount: ₹" + amount);
    }
}
