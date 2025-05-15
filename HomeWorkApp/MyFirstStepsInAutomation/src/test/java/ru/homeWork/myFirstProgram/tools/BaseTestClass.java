package ru.homeWork.myFirstProgram.tools;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.homeWork.myFirstProgram.mainPage.LoginPage;
import ru.homeWork.myFirstProgram.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTestClass {
    public static final Logger logger = LoggerFactory.getLogger(TestLoginPage.class);
    protected static final String ADMIN_LOGIN = "standard_user";
    protected static final String ADMIN_PASSWORD = "secret_sauce";

    @BeforeTest(alwaysRun = true)
    public void preconditions() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.headless = false;
        open(Configuration.baseUrl);
        logger.info("Test set up and open page {}", Configuration.baseUrl);

    }

    protected MainPage loginInSite(){
        return new LoginPage().enterLoginData(ADMIN_LOGIN).
                enterPasswordData(ADMIN_PASSWORD).
                clickLoginButton();
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }

}
