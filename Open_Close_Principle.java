import java.util.ArrayList;
import java.util.List;
/**
 * Interface representing a strategy for discounting food items.
 */
abstract class FoodDiscountStrategy {
    /**
     * Applies a discount to the total price of food items.
     *
     * @param totalPrice The total price of the food order.
     * @return The discounted total price.
     */
    abstract double applyDiscount(double totalPrice);
}

/**
 * Concrete strategy for discounting food items by a percentage.
 */
class PercentageFoodDiscount extends FoodDiscountStrategy {
    private double percentage;

    /**
     * Constructs a PercentageFoodDiscount object with the specified percentage.
     *
     * @param percentage The percentage discount to apply.
     */
    public PercentageFoodDiscount(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Applies a percentage discount to the total price of food items.
     *
     * @param totalPrice The total price of the food order.
     * @return The discounted total price.
     */
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * (1 - percentage / 100);
    }
}

/**
 * Concrete strategy for discounting food items by a fixed amount.
 */
class FixedAmountFoodDiscount extends FoodDiscountStrategy {
    private double amount;

    /**
     * Constructs a FixedAmountFoodDiscount object with the specified amount.
     *
     * @param amount The fixed amount discount to apply.
     */
    public FixedAmountFoodDiscount(double amount) {
        this.amount = amount;
    }

    /**
     * Applies a fixed amount discount to the total price of food items.
     *
     * @param totalPrice The total price of the food order.
     * @return The discounted total price.
     */
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice - amount;
    }
}

/**
 * Context class that applies a discount to the total price of food items based on the provided food discount strategy.
 */
class FoodDiscountApplier {
    private FoodDiscountStrategy foodDiscountStrategy;

    /**
     * Constructs a FoodDiscountApplier object with the specified food discount strategy.
     *
     * @param foodDiscountStrategy The food discount strategy to apply.
     */
    public FoodDiscountApplier(FoodDiscountStrategy foodDiscountStrategy) {
        this.foodDiscountStrategy = foodDiscountStrategy;
    }

    /**
     * Applies a discount to the total price of food items using the provided food discount strategy.
     *
     * @param totalPrice The total price of the food order.
     * @return The discounted total price.
     */
    public double applyDiscount(double totalPrice) {
        return foodDiscountStrategy.applyDiscount(totalPrice);
    }
}

/**
 * Demo class showcasing the usage of various food discount strategies.
 */
public class Open_Close_Principle_Food {
    public static void main(String[] args) {
        List<FoodDiscountApplier> foodDiscountAppliers = new ArrayList<>();
        foodDiscountAppliers.add(new FoodDiscountApplier(new PercentageFoodDiscount(10))); // 10% discount
        foodDiscountAppliers.add(new FoodDiscountApplier(new FixedAmountFoodDiscount(5))); // $5 fixed discount

        double totalPrice = 100; // Total price of the food order

        for (FoodDiscountApplier foodDiscountApplier : foodDiscountAppliers) {
            totalPrice = foodDiscountApplier.applyDiscount(totalPrice);
        }

        System.out.println("Final price after applying food discounts: $" + totalPrice);
    }
}

/**
 * Even though the applyDiscount method differs between PercentageFoodDiscount
 * and FixedAmountFoodDiscount classes, changes to the FoodDiscountStrategy class
 * are unnecessary when applying any discount type.
 */
