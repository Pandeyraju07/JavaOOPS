package inheritance;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Payment ID (numeric): ");
            String paymentId = scanner.next().trim();

            System.out.print("Enter Amount: ");
            BigDecimal amount = scanner.nextBigDecimal();

            System.out.print("Select Payment Type (1 = Credit Card, 2 = UPI): ");
            int choice = scanner.nextInt();

            Payment payment;

            if (choice == 1) {
                System.out.print("Enter last 4 digits of card: ");
                String cardDigits = scanner.next().trim();

                payment = new CreditCardPayment(
                        paymentId,
                        amount,
                        cardDigits
                );

            } else if (choice == 2) {
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.next().trim();

                payment = new UpiPayment(
                        paymentId,
                        amount,
                        upiId
                );

            } else {
                throw new IllegalArgumentException("Invalid payment type selected");
            }

            payment.process();

            System.out.println("\nPayment Processed Successfully");
            System.out.println("Payment Status: " + payment.getStatus());

        } catch (Exception ex) {
            // Centralized failure handling
            System.err.println("Payment failed: " + ex.getMessage());
        }
    }
}

