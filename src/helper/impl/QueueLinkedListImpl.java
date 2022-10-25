package helper.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import helper.List;
import helper.Queue;

public class QueueLinkedListImpl<E> implements Queue<E> {
    private List<E> linkedList;

    public QueueLinkedListImpl() {
        this.linkedList = new DoublyLinkedListImpl<>();
    }

    public QueueLinkedListImpl(E first) {
        this();
        this.linkedList.insert(first);
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty!");
        return this.linkedList.removeFirst();
    }

    @Override
    public void enqueue(E value) {
        this.linkedList.insertLast(value);
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public E peek() {
        return this.linkedList.peekFirst();
    }

    @Override
    public int size() {
        return this.linkedList.size();
    }

    @Override
    public Iterator<E> iterator() {
        return this.linkedList.iterator();
    }

}
