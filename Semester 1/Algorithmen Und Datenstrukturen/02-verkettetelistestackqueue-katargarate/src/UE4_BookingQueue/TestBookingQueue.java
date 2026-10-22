package UE4_BookingQueue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBookingQueue
{
    @Test
    public void testGetCount() throws QueueEmptyException
    {
        BookingQueue bookingQueue = new BookingQueue();
        assertEquals("leere Queue", 0, bookingQueue.getCount());

        Booking dmBooking = new Booking("dm-Einkauf", -6.78);
        bookingQueue.enqueue(dmBooking);
        assertEquals("eine Buchung", 1, bookingQueue.getCount());

        Booking fmBooking = new Booking("Finanzministerium Rückzahlung", +170.45);
        bookingQueue.enqueue(fmBooking);
        assertEquals("zwei Buchungen", 2, bookingQueue.getCount());

        Booking rentBooking = new Booking("Miete", -548.00);
        bookingQueue.enqueue(rentBooking);
        assertEquals("drei Buchungen", 3, bookingQueue.getCount());

        bookingQueue.dequeue();
        assertEquals("zwei Buchungen", 2, bookingQueue.getCount());

        bookingQueue.dequeue();
        assertEquals("eine Buchung", 1, bookingQueue.getCount());

        bookingQueue.dequeue();
        assertEquals("leere Queue", 0, bookingQueue.getCount());
    }

    @Test (expected = QueueEmptyException.class)
    public void testDequeueEmptyQueue() throws QueueEmptyException
    {
        BookingQueue bookingQueue = new BookingQueue();
        bookingQueue.dequeue();
    }

    @Test
    public void testFirstBookingInQueue()
    {
        BookingQueue bookingQueue = new BookingQueue();

        Booking bankBooking = new Booking("Bankgebühren", -7.99);
        bookingQueue.enqueue(bankBooking);

        Booking holidayBooking = new Booking("Hotelbuchung Lissabon", -239.00);
        bookingQueue.enqueue(holidayBooking);

        assertEquals(bankBooking, bookingQueue.getFront().getBooking());
    }

}
