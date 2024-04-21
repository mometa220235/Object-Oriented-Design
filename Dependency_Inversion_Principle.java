import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a method for grading students.
 */
interface GradingMethod {
    /**
     * Grades a student based on the provided score.
     *
     * @param score The score of the student.
     * @return The grade assigned to the student.
     */
    String gradeStudent(int score);
}

/**
 * Class representing a grading system.
 */
class GradingSystem {
    private final List<GradingMethod> gradingMethods;

    /**
     * Constructs a new GradingSystem with the given grading methods.
     *
     * @param gradingMethods The list of grading methods.
     */
    public GradingSystem(List<GradingMethod> gradingMethods) {
        this.gradingMethods = gradingMethods;
    }

    /**
     * Grades a student using all the configured grading methods.
     *
     * @param score The score of the student.
     * @return The grade assigned to the student.
     */
    public List<String> gradeStudent(int score) {
        List<String> grades = new ArrayList<>();
        for (GradingMethod method : gradingMethods) {
            grades.add(method.gradeStudent(score));
        }
        return grades;
    }
}

/**
 * Class representing a numeric grading method.
 */
class NumericGrading implements GradingMethod {
    @Override
    public String gradeStudent(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

/**
 * Class representing a pass/fail grading method.
 */
class PassFailGrading implements GradingMethod {
    @Override
    public String gradeStudent(int score) {
        return (score >= 60) ? "Pass" : "Fail";
    }
}

/**
 * Demo class demonstrating the usage of a grading system with different grading methods.
 */
public class Dependency_Inversion_Principle_Student {
    public static void main(String[] args) {
        // Create numeric and pass/fail grading methods
        GradingMethod numericMethod = new NumericGrading();
        GradingMethod passFailMethod = new PassFailGrading();

        // Create a grading system with numeric and pass/fail grading methods
        List<GradingMethod> methods = new ArrayList<>();
        methods.add(numericMethod);
        methods.add(passFailMethod);
        GradingSystem gradingSystem = new GradingSystem(methods);

        // Grade a student using all methods
        List<String> grades = gradingSystem.gradeStudent(75);
        System.out.println("Grades: " + grades);
    }
}

/**
 * We have an interface GradingMethod representing a method for grading students.
 * The NumericGrading and PassFailGrading classes implement the GradingMethod
 * interface to represent numeric and pass/fail grading methods, respectively.
 * The GradingSystem class represents a grading system that can grade students
 * using different methods. It depends on the abstraction provided by the GradingMethod
 * interface, allowing it to use any grading method without being coupled to specific implementations.
 * The Dependency_Inversion_Principle_Student class demonstrates the usage of the grading system
 * with different grading methods. It creates instances of NumericGrading and PassFailGrading
 * and configures the grading system with them, adhering to the Dependency Inversion Principle
 * by depending on abstractions rather than concrete implementations.
 */
