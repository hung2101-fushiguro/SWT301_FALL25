import hungth.example.Calculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @ParameterizedTest(name = "Test {index} ==> {0} * {1} = {2}")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testMultiplyFromFile(int a, int b, int expected) {
        int result = new Calculator().multiply(a, b);
        assertEquals(expected, result, () -> a + " * " + b + " should be " + expected);
    }


}
