package interfaces;

public final class EmailNotification implements NotificationService {

    private final String email;

    public EmailNotification(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;
    }

    @Override
    public void notify(String message) {
        System.out.println("EMAIL sent to " + email + ": " + message);
    }
}

