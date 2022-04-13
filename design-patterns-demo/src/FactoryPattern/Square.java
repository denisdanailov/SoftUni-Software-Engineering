package FactoryPattern;

import FactoryPattern.interfaces.ShapeInterface;

public class Square implements ShapeInterface {
    @Override
    public void draw() {
        System.out.println("Inside square::draw() method.");
    }
}
