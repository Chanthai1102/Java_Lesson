package OOP.Polymorphism;

public class Triangle extends Shape {
    private double a ;
    private double b ;
    private double c ;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getArea() {
        double p = (a + b + c);
        return Math.sqrt(p * (p-a) * (p-b) * (p-c));
    }

    @Override
    String getType() {
        return "Triangle";
    }
}
