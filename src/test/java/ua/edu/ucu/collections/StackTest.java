package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPeekIsTheSame() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Object actRes = stack.peek();
        assertEquals(4, actRes);

        actRes = stack.peek();
        assertEquals(4, actRes);
    }

    @Test
    public void testPeekPopedLater() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Object actRes = stack.peek();
        assertEquals(4, actRes);

        stack.pop();
        actRes = stack.peek();
        assertEquals(3, actRes);
    }

    @Test
    public void testPeekPushedLater() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(5);

        Object actRes = stack.peek();
        assertEquals(5, actRes);

        stack.push(55);
        actRes = stack.peek();
        assertEquals(55, actRes);
    }

    @Test
    public void testPeekOneEl() {
        Stack stack = new Stack();
        stack.push(2);

        Object actRes = stack.peek();
        assertEquals(2, actRes);

        actRes = stack.peek();
        assertEquals(2, actRes);
    }

    @Test
    public void testPopClassic() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(5);

        Object actRes = stack.pop();
        assertEquals(5, actRes);

        actRes = stack.pop();
        assertEquals(3, actRes);
    }

    @Test
    public void testPopPushed() {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(4);

        Object actRes = stack.pop();
        assertEquals(4, actRes);

        stack.push(50);
        actRes = stack.pop();
        assertEquals(50, actRes);

        actRes = stack.pop();
        assertEquals(2, actRes);
    }
    
}
