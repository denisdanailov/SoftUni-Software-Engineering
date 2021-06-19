package Generics_Exercise.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<E extends Comparable<E>> {
    private List<E> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(E element) {
        this.data.add(element);
    }

    public E remove(int index) {
       return this.data.remove(index);
    }

    public boolean contains(E element) {
        return this.data.contains(element);
    }

    public int size() {
        return this.data.size();
    }

    public void sort() {
        Collections.sort(data);
    }

    public E get(int index) {
        return this.data.get(index);
    }

    public void swap(int indexOne, int indexTwo) {
//        E currentElement = this.data.get(indexOne);
//        this.data.set(indexOne, this.data.get(indexTwo));
//        this.data.set(indexTwo, currentElement);

        Collections.swap(this.data,indexOne,indexTwo);
    }

    public long countGreaterThan(E element) {

        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public E getMax() {
        E maxElement = this.data.get(0);
        for (E datum : data) {
            if (datum.compareTo(maxElement) > 0) {
                maxElement = datum;
            }
        }
        return maxElement;
    }

    public E getMin() {
        E minElement = this.data.get(0);
        for (E datum : data) {
            if (datum.compareTo(minElement) < 0) {
                minElement = datum;
            }
        }
        return minElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E value : this.data) {
            sb
                    .append(String.format("%s", value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
