package encapsulation;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {

    private final long accountNumber;
    private BigDecimal balance;

    public BankAccount(String accountNumber) {
        validateAccountNumber(accountNumber);
        this.accountNumber = Long.parseLong(accountNumber);
        this.balance = BigDecimal.ZERO;
    }

    public synchronized void deposit(BigDecimal amount) {
        validateAmount(amount);
        balance = balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount) {
        validateAmount(amount);

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance = balance.subtract(amount);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private void validateAccountNumber(String accountNumber) {
        Objects.requireNonNull(accountNumber, "Account number cannot be null");

        if (!accountNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Account number must be numeric");
        }
    }

    private void validateAmount(BigDecimal amount) {
        Objects.requireNonNull(amount, "Amount cannot be null");

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }
}
