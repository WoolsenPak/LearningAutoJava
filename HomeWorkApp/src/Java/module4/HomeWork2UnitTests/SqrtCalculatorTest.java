package module4.HomeWork2UnitTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SqrtCalculatorTest extends BaseTest {
        @Parameters({"a"})

        @Test
        public void testSqrtCalculator(int a) {
            double result = calculator.sqrt(a);

            Assert.assertEquals(result,12, "Проверка провалилась. Сумма некорректна");
        }
    }


