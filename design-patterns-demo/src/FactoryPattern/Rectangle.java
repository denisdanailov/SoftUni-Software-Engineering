package FactoryPattern;

import FactoryPattern.interfaces.ShapeInterface;

public class Rectangle implements ShapeInterface {
    @Override
    public void draw() {
        System.out.println("Inside rectangle::draw() method.");
    }
}
