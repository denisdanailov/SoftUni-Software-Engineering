package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final int INITIAL_CAPACITY = 7;

    private int size;
    private int head;
    private int tail;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        head = tail = middle;
    }

    @Override
    public void add(E element) {
        addLast(element);
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;

        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;

        int begin = middle - this.size / 2;

        int index = this.head;

        for (int i = begin; index <= this.tail; i++) {
            newElements[i] = this.elements[index++];

        }

        this.head = begin;
        this.tail = this.head + this.size - 1;
        return newElements;

    }

    @Override
    public void offer(E element) {
        add(element);
    }

    @Override
    public void addFirst(E element) {
        if (size == 0) {
            add(element);
        } else {
            if (this.tail == size) {
                this.elements = grow();
            }
            this.elements[--this.head] = element;
            this.size++;
        }

    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        addFirst(element);
    }

    @Override
    public void insert(int index, E element) {

    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public E peek() {
        if (this.size != 0) {
            return getAt(this.head);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[this.head];
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E get(int index) {

        return null;
    }

    @Override
    public E get(Object object) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E remove(Object object) {
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {

            E element = getAt(this.head);
            this.elements[this.head] = null;
            this.head++;
            this.size--;

            return element;
        }

        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {

            E element = getAt(this.tail);
            this.elements[this.tail--] = null;
            this.size--;

            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;
            @Override
            public boolean hasNext() {
                return index != head;
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
}
