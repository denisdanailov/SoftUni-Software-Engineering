package Generics_Exercise.GenericSwapMethodIntegers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
//        T firstElement = elements.get(firstIndex);
//        T secondElement = elements.get(secondIndex);
//
//        this.elements.set(firstIndex,secondElement);
//        this.elements.set(secondIndex,firstElement);

       Collections.swap(this.elements, firstIndex, secondIndex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : elements) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
