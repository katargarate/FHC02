package Own.Factory.Benachrichtigungen;

public class Main {
    static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();
        test(factory.createNotification("sms"));
        test(factory.createNotification("email"));
        test(factory.createNotification("push"));
        test(factory.createNotification("xyz"));
    }

    public static void test(Notification notification) {
        if (notification != null) {
            notification.send("hello world!");
        } else System.out.println("Notification is null. Wrong type given. Notification not sent.");
    }

    // Der aufrufende Code kennt nur das Interface Notification, nicht die konkreten Klassen. Die Erzeugung steht an
    // einer Stelle, und neue Benachrichtigungsarten brauchen nur eine neue Klasse und eine Zeile in der Own.Factory,
    // ohne den aufrufenden Code zu ändern.
}
