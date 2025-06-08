package SOLID;

import java.util.HashMap;
import java.util.Map;

/*Fix I did:
 * Created an interface DiscountStrategy that defines a method calculateDiscount.
 * Each customer type discount logic is moved to its own class implementing this interface.
 * DiscountCalculator holds a map of strategies keyed by customer type.
 * You can add new discount types by adding new classes, and register them dynamically with addDiscountStrategy.
 * No modification to existing discount calculation logic needed for new customer types.
 */
public class OCP_01 {

    // Step 1: Define an interface for discount calculation
    public interface DiscountStrategy {
        double calculateDiscount(double amount);
    }

    // Step 2: Implement concrete discount strategies
    public static class RegularDiscount implements DiscountStrategy {
        public double calculateDiscount(double amount) {
            return amount * 0.1;
        }
    }

    public static class PremiumDiscount implements DiscountStrategy {
        public double calculateDiscount(double amount) {
            return amount * 0.2;
        }
    }

    // Step 3: DiscountCalculator now uses DiscountStrategy instead of strings & if-else
    public static class DiscountCalculator {
        private Map<String, DiscountStrategy> strategies = new HashMap<>();

        public DiscountCalculator() {
            // Register known discount types
            strategies.put("Regular", new RegularDiscount());
            strategies.put("Premium", new PremiumDiscount());
        }

        public void addDiscountStrategy(String customerType, DiscountStrategy strategy) {
            strategies.put(customerType, strategy);
        }

        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategies.get(customerType);
            if (strategy == null) {
                return 0.0;
            }
            return strategy.calculateDiscount(amount);
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();

        double regularDiscount = calculator.calculateDiscount("Regular", 100.0);
        double premiumDiscount = calculator.calculateDiscount("Premium", 100.0);

        System.out.println("Regular Discount: " + regularDiscount);
        System.out.println("Premium Discount: " + premiumDiscount);

        // Add new discount type without modifying existing class
        calculator.addDiscountStrategy("VIP", amount -> amount * 0.3);

        double vipDiscount = calculator.calculateDiscount("VIP", 100.0);
        System.out.println("VIP Discount: " + vipDiscount);
    }
}