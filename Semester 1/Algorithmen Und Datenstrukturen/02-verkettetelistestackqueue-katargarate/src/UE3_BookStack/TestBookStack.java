package UE3_BookStack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBookStack
{
    @Test
    public void testGetCount() throws StackEmptyException
    {
        BookStack bookStack = new BookStack();

        assertEquals("leerer Stapel", 0, bookStack.getCount());

        bookStack.push("1984");
        assertEquals("ein Buch", 1, bookStack.getCount());

        bookStack.push("Der kleine Prinz");
        assertEquals("zwei Bücher", 2, bookStack.getCount());

        bookStack.push("Robinson Crusoe");
        assertEquals("drei Bücher", 3, bookStack.getCount());

        bookStack.pop();
        assertEquals("zwei Bücher", 2, bookStack.getCount());

        bookStack.pop();
        assertEquals("ein Buch", 1, bookStack.getCount());

        bookStack.pop();
        assertEquals("leerer Stapel", 0, bookStack.getCount());
    }

    @Test (expected = StackEmptyException.class)
    public void testPopEmptyStack() throws StackEmptyException
    {
        BookStack bookStack = new BookStack();
        bookStack.pop();
    }

    @Test
    public void testFirstBookTitle()
    {
        BookStack bookStack = new BookStack();

        bookStack.push("Nichts als die Wahrheit");
        bookStack.push("Die Physiker");

        Node firstBook = bookStack.getTop();
        assertEquals("Die Physiker", firstBook.getBookTitle());
    }

}
