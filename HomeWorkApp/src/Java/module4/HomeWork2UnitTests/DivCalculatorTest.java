package module4.HomeWork2UnitTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DivCalculatorTest extends BaseTest {
    @Parameters ({"a", "b"})

    @Test (description = "Тест не работает как требуется. Считает double как int, отметая данные после запятой")
    public void testDiv(int a, int b) {
        double result = calculator.div(a, b);

        Assert.assertEquals(result, 3, "Проверка провалилась. Сумма некорректна");
    }
}

