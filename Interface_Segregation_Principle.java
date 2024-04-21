mimport java.util.ArrayList;
import java.util.List;

// Interface representing the ability to eat
interface Eatable {
    void eat();
}

// Interface representing the ability to cook
interface Cookable {
    void cook();
}

// Interface representing the ability to bake
interface BakedGoods {
    void bake();
}

// Class representing a Chef who can cook and bake
class Chef implements Cookable, BakedGoods {
    @Override
    public void cook() {
        System.out.println("Chef is cooking.");
    }

    @Override
    public void bake() {
        System.out.println("Chef is baking.");
    }
}

// Class representing a Baker who can bake
class Baker implements BakedGoods {
    @Override
    public void bake() {
        System.out.println("Baker is baking.");
    }
}

// Demo class demonstrating the usage of food-related roles and the Interface Segregation Principle
public class Interface_Segregation_Principle_Food {
    public static void main(String[] args) {
        // Create a list of food-related roles
        List<Object> roles = new ArrayList<>();
        roles.add(new Chef());
        roles.add(new Baker());

        // Perform actions based on each role
        for (Object role : roles) {
            if (role instanceof Cookable) {
                ((Cookable) role).cook();
            }
            if (role instanceof BakedGoods) {
                ((BakedGoods) role).bake();
            }
            if (role instanceof Eatable) {
                ((Eatable) role).eat(); // Assume eating is a common action for all food-related roles
            }
            System.out.println();
        }
    }
}

/**
 * In the above program, we have interfaces representing specific food-related tasks,
 * such as cooking and baking, instead of a single interface containing all tasks.
 * This allows classes like Chef and Baker to implement only the interfaces relevant
 * to their roles, adhering to the Interface Segregation Principle.
 */
