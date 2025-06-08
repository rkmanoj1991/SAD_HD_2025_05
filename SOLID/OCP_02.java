package SOLID;

public class OCP_02 {

    /*
     * FIX:
     * Introduced an abstract method `getArea()` in the Shape class.
     * Each concrete shape class implements its own `getArea()` method.
     * AreaCalculator no longer needs to know about specific shape types,
     * so it doesn't need to be modified when new shapes are added.
     * This respects the Open/Closed Principle.
     */
    
    public static abstract class Shape {
        public abstract double getArea();
    }

    public static class Square extends Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double getArea() {
            return side * side;
        }
    }

    public static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class AreaCalculator {
        public double getArea(Shape shape) {
            return shape.getArea();  // Polymorphism - no need for instanceof
        }
    }
    
    // Optional main method for testing
    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();

        Shape square = new Square(5);
        Shape circle = new Circle(3);

        System.out.println("Square area: " + calculator.getArea(square));
        System.out.println("Circle area: " + calculator.getArea(circle));
    }
}