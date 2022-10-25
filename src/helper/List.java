package helper;

import model.Node;

public interface List<E> extends Iterable<E> {

    // O(n)
    void clear();

    // constant
    int size();

    // constant
    boolean isEmpty();

    // O(1)
    void insert(E element);

    // O(1)
    void insertFirst(E element);

    // O(1)
    void insertLast(E element);

    // O(1)
    E peekFirst();

    // O(1)
    E peekLast();

    // O(1)
    E removeFirst();

    // O(1)
    E removeLast();

    // O(1)
    E remove(Node<E> node);

    // O(n)
    boolean remove(Object object);

    // O(n)
    E removeAt(int index);

    // O(n)
    int indexOf(Object object);

    // O(n)
    boolean contains(Object object);
}
