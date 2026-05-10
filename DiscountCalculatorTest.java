import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DiscountCalculatorTest {

    private final DiscountCalculator calculator = new DiscountCalculator();

    @ParameterizedTest
    @CsvSource({
        "'NEW',     5,  true,  7.0",
        "'NEW',     2,  false, 5.0",
        "'REGULAR', 15, true,  15.0",
        "'REGULAR', 5,  false, 8.0",
        "'PREMIUM', 15, false, 15.0",
        "'PREMIUM', 5,  true,  12.0"
    })
    void testCalculateDiscount(String type, int orders, boolean sub, double expected) {
        assertEquals(expected, calculator.calculateDiscount(type, orders, sub), 0.001);
    }

    @Test
    void testInfeasibleCombination() {
        assertThrows(IllegalArgumentException.class, () -> { [cite: 42]
            calculator.calculateDiscount("NEW", 10, false);
        });
    }
}