package abstraction;

import java.util.Scanner;

public class NotificationApp {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Select Notification Type (1 = Email, 2 = SMS): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Notification notification;

            if (choice == 1) {
                System.out.print("Enter Email Address: ");
                String email = scanner.nextLine();
                notification = new EmailNotification(email);

            } else if (choice == 2) {
                System.out.print("Enter Phone Number: ");
                String phone = scanner.nextLine();
                notification = new SmsNotification(phone);

            } else {
                throw new IllegalArgumentException("Invalid notification type");
            }

            System.out.print("Enter Message: ");
            String message = scanner.nextLine();

            notification.send(message);

            System.out.println("Notification sent successfully");

        } catch (Exception ex) {
            System.err.println("Notification failed: " + ex.getMessage());
        }
    }
}

