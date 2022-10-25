package helper.impl;

import java.util.Iterator;

import helper.List;
import helper.Stack;

public class StackLinkedListImpl<E> implements Stack<E> {

    private List<E> linkedList;

    public StackLinkedListImpl() {
        this.linkedList = new DoublyLinkedListImpl<>();
    }

    public StackLinkedListImpl(E first) {
        this();
        this.linkedList.insert(first);
    }

    @Override
    public boolean isEmpty() {
        return this.linkedList.isEmpty();
    }

    @Override
    public E pop() {
        return this.linkedList.removeFirst();
    }

    @Override
    public void push(E value) {
        this.linkedList.insertFirst(value);
    }

    @Override
    public E top() {
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
