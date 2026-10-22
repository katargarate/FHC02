package ExtraThreadsExamples;

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        /*
         * A thread is a thread of execution in a program. The Java
         * Virtual Machine allows an application to have multiple threads of
         * execution running concurrently.

         * currentThread(): Returns a reference to the currently executing thread object.
         * .getName(): Returns this thread's name.
         */

        System.out.println("Inside : " + Thread.currentThread().getName());

        System.out.println("Creating Runnable ...");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread ...");
        Thread thread = new Thread(runnable); // Status New
        // thread.setName("neu");
        System.out.println(thread.getName());

        System.out.println("Starting Thread");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("Inside new Thread : " + Thread.currentThread().getName());
    }
}
