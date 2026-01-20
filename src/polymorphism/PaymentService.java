package polymorphism;

import java.util.Scanner;

public class PaymentService {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Payment payment;

        System.out.println("Select Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");

        int choice = sc.nextInt();

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        // Runtime object selection
        switch (choice) {
            case 1:
                payment = new CreditCardPayment();
                break;
            case 2:
                payment = new UPIPayment();
                break;
            case 3:
                payment = new NetBankingPayment();
                break;
            default:
                System.out.println("Invalid payment option");
                sc.close();
                return;
        }

        // Polymorphic call
        payment.processPayment(amount);
        payment.generateReceipt(amount);

        sc.close();
    }
}
