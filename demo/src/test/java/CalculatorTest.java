import static org.junit.jupiter.api.Assertions.*;

import com.example.models.Calculator;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.subtract(3, 2), "3 - 2 should equal 1");
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0), "Dividing by zero should throw IllegalArgumentException");
    }
}
