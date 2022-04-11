package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int INITIAL_DEFAULT_CAPACITY = 8;
    private static final int CAPACITY_INCREASE_MULTIPLIER = 2;
    private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Index is out of bounds";

    private E[] elements;
    private int capacity;
    private int size;

    public ArrayList() {
        this(INITIAL_DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        capacity = initialCapacity;
        elements = (E[]) new Object[capacity];
    }

    @Override
    public boolean add(E element) {
        growIfNeeded();
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, E element) {
        growIfNeeded();
        shiftRight(index);
        elements[index] = element;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
           checkIndex(index);

        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);

        E oldValue = (E)elements[index];
        elements[index] = element;

        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedValue =  elements[index];
        shiftLeft(index);
        size--;

        return removedValue;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E element) {

        for (int i = 0; i < elements.length ; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int indexCounter = 0;

            @Override
            public boolean hasNext() {
                return indexCounter < size;
            }

            @Override
            public E next() {
                return (E)elements[indexCounter++];
            }
        };
    }


    private void shiftRight(int index) {

        for (int i = this.elements.length + 1; i > index ; i--) {

            elements[i] = elements[i - 1];
        }
    }

    private void checkIndex(int index) {
        if (index >= this.size  || index < 0) {
            throw new IllegalArgumentException("Invalid Index");
        }
    }

    private void shiftLeft(int index) {

        for (int i = index ; i < size ; i++) {
            elements[i] = elements[i + 1];
        }
    }


    private boolean needsToGrow() {
        return size + 1 > capacity;
    }

    private void increaseCapacity() {
        capacity *= CAPACITY_INCREASE_MULTIPLIER;
    }

    private void growIfNeeded() {
        if (needsToGrow()) {
            increaseCapacity();
            elements = Arrays.copyOf(elements, capacity);
        }
    }
}


