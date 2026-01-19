package interfaces;

public final class SmsNotification implements NotificationService {

    private final String phone;

    public SmsNotification(String phone) {
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    @Override
    public void notify(String message) {
        System.out.println("SMS sent to " + phone + ": " + message);
    }
}

