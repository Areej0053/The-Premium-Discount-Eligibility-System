import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    // 1. This is the Parameterized Test for your Pair-Wise combinations 
    @ParameterizedTest
    @CsvSource({
        // format: customerType, orders, newsletter, expectedDiscount
        "'NEW', 5, true, 7.0",
        "'REGULAR', 12, true, 15.0",
        "'PREMIUM', 0, false, 10.0",
        "'REGULAR', 2, false, 8.0",
        "'PREMIUM', 15, true, 15.0"
    })
    void testCalculateDiscount(String type, int orders, boolean sub, double expected) {
        assertEquals(expected, calculator.calculateDiscount(type, orders, sub), 0.001);
    }

    // 2. This tests the "Error" rule using assertThrows [cite: 42]
    @Test
    void testInfeasibleCombination() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDiscount("NEW", 10, false);
        });
    }
}