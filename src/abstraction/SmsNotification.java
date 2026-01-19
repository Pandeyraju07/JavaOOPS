package abstraction;

public final class SmsNotification extends Notification {

    private final String phoneNumber;

    public SmsNotification(String phoneNumber) {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    protected void sendInternal(String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
