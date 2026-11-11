package Own.Factory.Benachrichtigungen;

public class NotificationFactory {
    public Notification createNotification(String type) {
        return switch (type.toLowerCase()) {
            case "email"  -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> null;
        };
    }
}
