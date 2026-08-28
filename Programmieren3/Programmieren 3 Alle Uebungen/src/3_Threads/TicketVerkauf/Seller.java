package TicketVerkauf;

public class Seller implements Runnable {
    private static final Object lock = new Object();
    private static int remainingTickets = 50;
    private static int turn = 0;
    private static boolean isRunning = true;

    private int ticketsSoldBySeller = 0;
    private int sellerID;


    public Seller(int sellerID) {
        this.sellerID = sellerID;
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (lock) {
                while (sellerID != turn && remainingTickets > 0 && isRunning) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                // if no tickets remain or isRunning has become false,
                if (!isRunning || remainingTickets == 0) {
                    lock.notifyAll();
                    break;
                }

                System.out.printf("\n%s verkauft Ticket! Verbleibend: %d", Thread.currentThread().getName(), --remainingTickets);

                ticketsSoldBySeller++; // increment the tickets sold by this seller
                turn = 1 - sellerID; // switch to the other seller's turn
                lock.notifyAll();

            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("\nSeller %d hat %d Tickets verkauft.\n", sellerID, ticketsSoldBySeller);
        System.out.println("Übergeblieben Tickets: " + remainingTickets);
    }

    public void requestShutDown() {
        isRunning = false;
    }
}
