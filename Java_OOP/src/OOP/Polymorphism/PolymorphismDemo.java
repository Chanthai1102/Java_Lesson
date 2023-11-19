package OOP.Polymorphism;

import java.util.Arrays;

public class PolymorphismDemo {
    public static void main(String[] args){
        Shape[] shapes = new Shape[] {
                new Circle(5),
                new Rectangle(6,7),
                new Triangle(3,5,3),
                new Circle(6),
                new Rectangle(9,5)
        };
        SortShapeByArea sortShapeByArea = new SortShapeByArea();
        SortShapeByType sortShapeByType = new SortShapeByType();
        Arrays.sort(shapes,sortShapeByType);
        for (Shape shape : shapes){
            shape.display();
        }
        double totalArea = 0.0 ;
        for (Shape shape : shapes){
            totalArea += shape.getArea();
        }
        System.out.println("Total Area : " + totalArea);
    }
}
