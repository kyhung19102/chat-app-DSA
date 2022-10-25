package helper.impl;

import java.util.Iterator;

import helper.List;
import model.Node;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private static int elements = 0;

    @Override
    public void insertLast(E e) {
        final Node<E> node = new Node<E>(e, null);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        ++elements;
    }

    @Override
    public void insertFirst(E e) {
        final Node<E> node = new Node<E>(e, null);
        if (head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(head);
            this.head = node;
        }
        ++elements;
    }

    @Override
    public void clear() {
        this.head = null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> cur = head; cur != null; cur = cur.getNext()) {
                if (cur.getValue() == null)
                    return index;
                ++index;
            }
        } else {
            for (Node<E> cur = head; cur != null; cur = cur.getNext()) {
                if (o.equals(cur.getValue()))
                    return index;
                ++index;
            }
        }
        return -1;
    }

    @Override
    public void insert(E element) {

    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public E remove(Node<E> node) {
        return null;
    }

    @Override
    public boolean remove(Object object) {
        return false;
    }

    @Override
    public E removeAt(int index) {
        return null;
    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private Node<E> getPrevNode(Node<E> node) {
        final Node<E> targetNode = node;
        for (Node<E> cur = head; cur != null; cur = cur.getNext())
            if (cur.getNext().equals(targetNode))
                return cur;
        return null;
    }

    private E unlink(Node<E> x) {
        final E element = x.getValue();
        final Node<E> prev = this.getPrevNode(x);
        final Node<E> next = x.getNext();

        if (x == head || prev == null) {
            unlinkFirst(x);
            return element;
        }
        if (x == tail || next == null) {
            unlinkLast(x);
            return element;
        }

        x.setValue(null);
        x.setNext(null);
        prev.setNext(next);

        return element;
    }

    private E unlinkFirst(Node<E> f) {
        final E element = f.getValue();
        final Node<E> next = f.getNext();
        f.setValue(null);
        f.setNext(null);
        head = next;
        if (next == null)
            tail = null;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        final E element = l.getValue();
        final Node<E> prev = this.getPrevNode(l);
        l.setValue(null);
        l.setNext(null);
        tail = prev;
        if (prev == null)
            head = null;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
