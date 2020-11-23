package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list = new ImmutableLinkedList();

    public Stack() {

    }
    Object peek() {
        return list.get(0);
    }

    Object pop() {
        Object res = this.peek();
        list = list.removeFirst();
        return res;
    }

    void push(Object e) {
        list = list.addFirst(e);
    }
}
