package P1_DoctorQueue;

public class Main {
    public static void main(String[] args) {
        DoctorQueue queue = new DoctorQueue();

        queue.enqueue("Monika Huber");
        System.out.println("Front - [SOLL] Monika Huber; [IST] " + printNameFromNode(queue.getFront()));
        System.out.println("Rear - [SOLL] Monika Huber; [IST] " + printNameFromNode(queue.getRear()));

        queue.enqueue("Hans Berger");
        System.out.println("Front - [SOLL] Monika Huber; [IST] " + printNameFromNode(queue.getFront()));
        System.out.println("Rear - [SOLL] Hans Berger; [IST] " + printNameFromNode(queue.getRear()));
        System.out.println("Next von Front - [SOLL] Hans Berger; [IST] " + (queue.getFront() == null ? "null" : printNameFromNode(queue.getFront().getNext())));

        queue.enqueue("Marianne Goldberger");
        System.out.println("Front - [SOLL] Monika Huber; [IST] " + printNameFromNode(queue.getFront()));
        System.out.println("Rear - [SOLL] Marianne Goldberger; [IST] " + printNameFromNode(queue.getRear()));
    }

    private static String printNameFromNode(Node node)
    {
        if (node == null)
            return "null";
        else
            return node.getName();
    }
}

