package test;

public class Test {
    static final SinglyLinkedListTest sll = new SinglyLinkedListTest();

    public static void main(String[] args) {
        testSLL();
    }

    static void testSLL() {
        sll.insert_element_at_first("Pham Duong");
        sll.insert_element_at_last("Minh An");
    }
}
