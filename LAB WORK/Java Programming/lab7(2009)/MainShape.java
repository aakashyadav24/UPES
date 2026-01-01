
interface Drawable {
    void draw();
}

abstract class Shape implements Drawable {
    abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    // Rectangle constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Square constructor (overloading)
    Rectangle(double side) {
        this.length = side;
        this.width = side;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    public void draw() {
        if (length == width) {
            System.out.println("Drawing a Square with side " + length);
        } else {
            System.out.println("Drawing a Rectangle " + length + " x " + width);
        }
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle with base " + base + " and height " + height);
    }
}

public class MainShape {
    public static void main(String[] args) {
        // Circle
        Circle circle = new Circle(5);
        circle.draw();
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("---------------------------");

        // Rectangle
        Rectangle rectangle = new Rectangle(10, 5);
        rectangle.draw();
        System.out.println("Rectangle area: " + rectangle.calculateArea());

        // Square using overloaded constructor
        Rectangle square = new Rectangle(6);
        square.draw();
        System.out.println("Square area: " + square.calculateArea());
        System.out.println("---------------------------");

        // Triangle
        Triangle triangle = new Triangle(8, 4);
        triangle.draw();
        System.out.println("Triangle area: " + triangle.calculateArea());
    }
}

