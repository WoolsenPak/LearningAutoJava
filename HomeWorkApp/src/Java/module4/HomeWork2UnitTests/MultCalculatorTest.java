package module4.HomeWork2UnitTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultCalculatorTest extends BaseTest{
    @Parameters({"a", "b"})

    @Test
    public void testMult(int a, int b){
        long result = calculator.mult(a,b);

        Assert.assertEquals(result,2, "Проверка провалилась. Сумма некорректна");
    }
}
