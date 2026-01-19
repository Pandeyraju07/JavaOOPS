package encapsulation;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Bank Account Number (numeric only): ");
            String accountNumber = scanner.next();

            BankAccount account = new BankAccount(accountNumber);

            System.out.print("Enter deposit amount: ");
            BigDecimal depositAmount = scanner.nextBigDecimal();
            account.deposit(depositAmount);

            System.out.print("Enter withdrawal amount: ");
            BigDecimal withdrawAmount = scanner.nextBigDecimal();
            account.withdraw(withdrawAmount);

            System.out.println("Final Balance: " + account.getBalance());

        } catch (Exception ex) {
            System.err.println("Operation failed: " + ex.getMessage());
        }
    }
}
