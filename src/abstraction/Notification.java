package abstraction;

public abstract class Notification {

    // Template method enforcing execution flow
    public final void send(String message) {
        validateMessage(message);
        sendInternal(message);
    }

    // Subclasses provide implementation
    protected abstract void sendInternal(String message);

    private void validateMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
    }
}
