public class DiscountCalculator {

    public double calculateDiscount
    (String customerType, int totalOrdersInLastYear, boolean isSubscribedToNewsletter) 
    {
        // 1. Check for the "Infeasible" Rule (Constraint) 
        if (customerType.equals("NEW") && totalOrdersInLastYear >= 10) {
            throw new IllegalArgumentException("NEW customers cannot have 10 or more orders.");
        }

        // 2. Base Discount 
        double totalDiscount = 5.0;

        // 3. Customer Type Bonus [cite: 23]
        if (customerType.equals("REGULAR")) {
            totalDiscount += 3.0;
        } else if (customerType.equals("PREMIUM")) {
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

        // 6. Maximum Cap 
        if (totalDiscount > 15.0) {
            totalDiscount = 15.0;
        }

        return totalDiscount;
    }
}