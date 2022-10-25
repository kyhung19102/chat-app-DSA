package test;

import helper.List;
import helper.impl.SinglyLinkedList;

public class SinglyLinkedListTest {
    private List<String> list = new SinglyLinkedList<>();

    public void insert_element_at_last(String msg) {
        list.insertLast(msg);
        System.out.println("Insert last successfully!");
    }

    public void insert_element_at_first(String msg) {
        list.insertFirst(msg);
        System.out.println("Insert first successfully!");
    }
}
