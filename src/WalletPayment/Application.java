package WalletPayment;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1. Take Order Details
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();

        System.out.print("Enter Order Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Order order = new Order(orderId, amount);

        // 2. Choose Payment Method
        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Payment payment;

        switch (choice) {
            case 1:
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                payment = new UpiPayment(upiId);
                break;

            case 2:
                System.out.print("Enter Card Number: ");
                String cardNumber = scanner.nextLine();
                payment = new CreditCardPayment(cardNumber);
                break;

            default:
                throw new IllegalArgumentException("Invalid payment option");
        }

        // 3. Process Order
        OrderService orderService = new OrderService();
        orderService.processOrder(order, payment);

        // 4. Output Result
        System.out.println("Order processed successfully");
        System.out.println("Final Order Status: " + order.getStatus());

        scanner.close();
    }
}

