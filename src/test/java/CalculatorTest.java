import objects.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.io.IOException;

public class CalculatorTest {
    Calculator calc;

    @BeforeMethod
    public void setup() {
        calc = new Calculator();
    }

    @Parameters({"value1", "value2", "result"})
    @Test(description = "Test for summ func of Calculator")
    public void summTest(@Optional("10") int value1, @Optional("5") int value2,
                         @Optional("15") double result) {
        Assert.assertEquals(result, calc.summ(value1, value2));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "calcData")
    public void dataTest(String value1, String value2, String result) throws
            IOException {
        Assert.assertEquals(Double.parseDouble(result), calc.summ(Integer.parseInt
                        (value1), Integer.parseInt(value2)));
    }
}
