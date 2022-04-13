package FactoryPattern;

import FactoryPattern.interfaces.ShapeInterface;

public class FactoryPattern {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        ShapeInterface circle = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        circle.draw();

        //get an object of Rectangle and call its draw method.
        ShapeInterface rectangle = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        rectangle.draw();

        //get an object of Square and call its draw method.
        ShapeInterface square = shapeFactory.getShape("SQUARE");

        //call draw method of Square
        square.draw();
    }
}
