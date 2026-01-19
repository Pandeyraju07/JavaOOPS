package constructor;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentTransactionApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Transaction ID (12 digits): ");
            String transactionId = scanner.next().trim();

            System.out.print("Enter Amount: ");
            BigDecimal amount = scanner.nextBigDecimal();

            System.out.print("Enter Currency (INR / USD / EUR): ");
            String currency = scanner.next().trim().toUpperCase();

            // Constructor enforces all business rules
            PaymentTransaction transaction =
                    new PaymentTransaction(transactionId, amount, currency);

            System.out.println("\nTransaction Created Successfully");
            System.out.println("Transaction ID : " + transaction.getTransactionId());
            System.out.println("Amount         : " + transaction.getAmount());
            System.out.println("Currency       : " + transaction.getCurrency());
            System.out.println("Created At     : " + transaction.getCreatedAt());

        } catch (Exception ex) {
            // Centralized failure handling
            System.err.println("Transaction creation failed: " + ex.getMessage());
        }
    }
}
