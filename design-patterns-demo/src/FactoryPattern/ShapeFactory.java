package FactoryPattern;

import FactoryPattern.Circle;
import FactoryPattern.Rectangle;
import FactoryPattern.interfaces.ShapeInterface;

public class ShapeFactory {

    public ShapeInterface getShape(String shapeType) {
        if (shapeType == null) {
            return null;

        }  if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
            
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();

        }
        return null;
    }
}
