package OOP.Polymorphism;

public class Rectangle extends Shape{
    private double width ;
    private double height ;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }

    @Override
    String getType() {
        return "Rectangle";
    }
}
