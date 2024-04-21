/**
 * This class defines a basic Food item.
 */
class Food {
    private String name; // Stores the name of the food item.
    private double price; // Represents the price of the food item.

    /**
     * Constructs a new Food instance with the specified name and price.
     *
     * @param name  The name of the food item.
     * @param price The price of the food item.
     */
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Retrieves the name of the food item.
     *
     * @return The name of the food item.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the price of the food item.
     *
     * @return The price of the food item.
     */
    public double getPrice() {
        return price;
    }
}

/**
 * This class represents a basic Food Management System.
 */
class FoodManagementSystem {

    /**
     * Displays the details of a food item.
     *
     * @param food The food item to display details for.
     */
    public void displayFoodDetails(Food food) {
        System.out.println("Food Details:");
        System.out.println("Name: " + food.getName());
        System.out.println("Price: $" + food.getPrice());
    }
}

/**
 * This class demonstrates the usage of Food and FoodManagementSystem classes.
 */
class FoodDemo {
    public static void main(String[] args) {
        // Create a food item
        Food food = new Food("Pizza", 10.99);

        // Manage food items using FoodManagementSystem
        FoodManagementSystem fms = new FoodManagementSystem();

        // Display food details using FoodManagementSystem
        fms.displayFoodDetails(food);
    }
}

/**
 * In the provided code, the responsibility of printing the food details is delegated to the FoodManagementSystem class,
 * allowing the Food class to solely focus on storing the attributes of a food item.
 */
