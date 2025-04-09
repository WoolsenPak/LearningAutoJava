package module4.HomeWork2UnitTests;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected Calculator calculator;

    @BeforeTest
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterTest
    public void tearDown() {
        calculator = null;
    }
}
