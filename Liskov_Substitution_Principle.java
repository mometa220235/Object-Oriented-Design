import java.util.ArrayList;
import java.util.List;
/**
 * Interface representing a planar figure.
 */
abstract class Shape {
    /**
     * Calculates the area of the shape.
     *
     * @return The area of the shape.
     */
    double computeArea();
}

/**
 * Class representing a quadrilateral.
 */
class Quadrilateral implements Shape {
    private double width;
    private double height;

    /**
     * Constructs a new Quadrilateral object with the given width and height.
     *
     * @param width  The width of the quadrilateral.
     * @param height The height of the quadrilateral.
     */
    public Quadrilateral(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double computeArea() {
        return width * height;
    }
}

/**
 * Class representing a square, a special case of a quadrilateral.
 */
class Square implements Shape {
    private double side;

    /**
     * Constructs a new Square object with the given side length.
     *
     * @param side The side length of the square.
     */
    public Square(double side) {
        this.side = side;
    }

    @Override
    public double computeArea() {
        return side * side;
    }
}

/**
 * Demo class demonstrating the usage of planar figures and the Liskov Substitution Principle.
 */
class Liskov_Substitution_Principle_Example {
    /**
     * Calculates the total area of planar figures and prints it.
     *
     * @param figures The list of planar figures.
     */
    public static void calculateTotalArea(List<Shape> figures) {
        double totalArea = 0;
        for (Shape figure : figures) {
            totalArea += figure.computeArea();
        }
        System.out.println("Total area of planar figures: " + totalArea);
    }

    public static void main(String[] args) {
        // Create a list of planar figures
        List<Shape> figures = new ArrayList<>();
        figures.add(new Quadrilateral(5, 4));
        figures.add(new Square(3));

        // Calculate and print the total area of planar figures
        calculateTotalArea(figures);
    }
}

/**
 * Despite being a subtype of Quadrilateral, the Square class allows us to substitute
 * a Square object for a Quadrilateral object without affecting the program's correctness.
 * This demonstrates adherence to the Liskov Substitution Principle.
 */
