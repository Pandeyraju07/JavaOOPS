package interfaces;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaymentApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Payment ID: ");
            String paymentId = scanner.next();

            System.out.print("Enter Amount: ");
            BigDecimal amount = scanner.nextBigDecimal();

            System.out.print("Payment Type (1 = Card, 2 = UPI): ");
            int payType = scanner.nextInt();

            System.out.print("Notify Via (1 = Email, 2 = SMS): ");
            int notifyType = scanner.nextInt();

            PaymentMethod paymentMethod;
            NotificationService notificationService;

            if (payType == 1) {
                System.out.print("Enter last 4 card digits: ");
                paymentMethod = new CreditCardPayment(scanner.next());
            } else {
                System.out.print("Enter UPI ID: ");
                paymentMethod = new UpiPayment(scanner.next());
            }

            if (notifyType == 1) {
                System.out.print("Enter Email: ");
                notificationService = new EmailNotification(scanner.next());
            } else {
                System.out.print("Enter Phone Number: ");
                notificationService = new SmsNotification(scanner.next());
            }

            PaymentProcessor processor =
                    new PaymentProcessor(paymentMethod, notificationService);

            processor.process(paymentId, amount);

        } catch (Exception ex) {
            System.err.println("Payment failed: " + ex.getMessage());
        }
    }
}

