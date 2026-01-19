package abstraction;

public final class EmailNotification extends Notification {

    private final String email;

    public EmailNotification(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    @Override
    protected void sendInternal(String message) {
        System.out.println("Sending EMAIL to " + email + ": " + message);
    }
}

