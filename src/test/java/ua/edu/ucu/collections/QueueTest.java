package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Object actRes = queue.peek();
        assertEquals(3, actRes);

        actRes = queue.peek();
        assertEquals(3, actRes);
    }

    @Test
    public void testPeekEnqueuedLater() {
        Queue queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Object actRes = queue.peek();
        assertEquals(3, actRes);

        queue.enqueue(6);
        actRes = queue.peek();
        assertEquals(3, actRes);
    }

    @Test
    public void testDequeue() {
        Queue queue = new Queue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Object actRes = queue.dequeue();
        assertEquals(3, actRes);

        actRes = queue.dequeue();
        assertEquals(4, actRes);

        actRes = queue.dequeue();
        assertEquals(5, actRes);
    }
}
