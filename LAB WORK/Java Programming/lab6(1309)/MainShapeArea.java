// Base Class
abstract class Shape {
    // Abstract method to be overridden
    public abstract double calculateArea();
}

// Circle subclass
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle area: " + area);
        return area;
    }
}

// Rectangle subclass
class Rectangle extends Shape {
    private double length;
    private double breadth;

    // Constructor for rectangle
    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Constructor for square
    public Rectangle(double side) {
        this.length = side;
        this.breadth = side;
    }

    // Method overloading for area
    public double area(double length, double breadth) {
        return length * breadth;
    }

    public double area(double side) {
        return side * side;
    }

    @Override
    public double calculateArea() {
        double area = length * breadth;
        System.out.println("Rectangle area: " + area);
        return area;
    }
}

// Triangle subclass
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        double area = 0.5 * base * height;
        System.out.println("Triangle area: " + area);
        return area;
    }
}

// Main class
public class MainShapeArea {
    public static void main(String[] args) {
        // Circle
        Circle circle = new Circle(7);
        circle.calculateArea();

        System.out.println("--------------------------");

        // Rectangle
        Rectangle rect = new Rectangle(10, 5);
        rect.calculateArea();
        System.out.println("Overloaded method (Rectangle 8x4): " + rect.area(8, 4));
        System.out.println("Overloaded method (Square 6): " + rect.area(6));

        System.out.println("--------------------------");

        // Triangle
        Triangle tri = new Triangle(10, 6);
        tri.calculateArea();
    }
}
