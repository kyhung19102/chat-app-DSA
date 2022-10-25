package helper;

public interface Queue<E> extends Iterable<E> {
    void enqueue(E value);

    E dequeue();

    E peek();

    boolean isEmpty();

    int size();
}
