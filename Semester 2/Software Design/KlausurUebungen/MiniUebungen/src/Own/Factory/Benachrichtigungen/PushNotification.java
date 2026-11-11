package Own.Factory.Benachrichtigungen;

public class PushNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Push Notification: " + message);
    }
}
