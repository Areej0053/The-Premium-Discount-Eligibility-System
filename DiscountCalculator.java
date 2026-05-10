public class DiscountCalculator {

    public double calculateDiscount(String customerType, int totalOrdersInLastYear, boolean isSubscribedToNewsletter) {
        
        // 1. Check for the "Infeasible" Rule (Constraint) [cite: 25, 26, 27]
        // Using "NEW".equals() protects against null values
        if ("NEW".equalsIgnoreCase(customerType) && totalOrdersInLastYear >= 10) {
            throw new IllegalArgumentException("NEW customers cannot have 10 or more orders.");
        }

        // 2. Base Discount 
        double totalDiscount = 5.0;

        // 3. Customer Type Bonus 
        if ("REGULAR".equalsIgnoreCase(customerType)) {
            totalDiscount += 3.0;
        } else if ("PREMIUM".equalsIgnoreCase(customerType)) {
            totalDiscount += 5.0;
        }

        // 4. Loyalty Bonus 
        if (totalOrdersInLastYear >= 10) {
            totalDiscount += 5.0;
        }

        // 5. Subscription Bonus 
        if (isSubscribedToNewsletter) {
            totalDiscount += 2.0;
        }

        // 6. Maximum Cap [cite: 28]
        // Using Math.min is a slightly cleaner way to write the cap logic
        return Math.min(totalDiscount, 15.0);
    }
}