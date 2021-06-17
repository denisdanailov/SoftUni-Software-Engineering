package WokrShop_LinkedList.LinkedList;

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {

    }

    private static class Node {
        private int element;
        private Node next;


        private Node(int element) {

            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);
        if (this.head != null) {
             newNode.next = this.head;
        }

        this.head = newNode;
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        Node current = this.head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        this.size++;


    }

    public int get(int index) {
       validateIndex(index);

       Node current = this.head;

       int currentIndex = 0;
       int result = 0;
       while (current.next != null) {
            if(currentIndex == index) {
                result = current.element;
                break;
            }
             currentIndex++;
            current = current.next;
       }
       return result;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalStateException("Index"
                    + index + " was out structure bound!");
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


}
