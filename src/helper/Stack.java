package helper;

public interface Stack<E> extends Iterable<E> {
    void push(E value);

    E pop();

    E top();

    boolean isEmpty();

    int size();
}
