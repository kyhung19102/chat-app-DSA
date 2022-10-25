package test;

import java.util.Iterator;

import helper.Queue;
import helper.impl.QueueLinkedListImpl;

public class QueueLinkedListTest {
    public static void main(String[] args) {
        int numberOfOperations = 10000000;
        long startTime = System.nanoTime();
        // Linked list based queue
        Queue<Integer> linkedListBasedQueue = new QueueLinkedListImpl<>();

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.enqueue(i);
        }
        for (int i = 0; i < numberOfOperations; i++) {
            linkedListBasedQueue.dequeue();
        }

        // linkedListBasedQueue.enqueue(1);
        // linkedListBasedQueue.dequeue();
        // System.out.println(linkedListBasedQueue.size());

        long endTime = System.nanoTime();
        long linkedListTime = endTime - startTime;
        System.out.println("Linked list based stack took: " + linkedListTime + "\n");
    }
}
