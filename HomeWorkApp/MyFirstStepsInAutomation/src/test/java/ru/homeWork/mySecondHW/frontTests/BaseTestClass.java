package ru.homeWork.mySecondHW.frontTests;


import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import ru.homeWork.mySecondHW.frontTests.pages.LoginPage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(BaseTestClass.class);

    protected static final String ADMIN_LOGIN = "Admin";
    protected static final String ADMIN_PASSWORD = "TestRoot1";

    @BeforeClass(alwaysRun = true)
    public void precondition() {
        logger.info("=== PREPARE TESTS START ===");
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "http://localhost:12301/";
        Configuration.headless = false;
        logger.info("=== PREPARE TESTS FINISH ===");
        open(Configuration.baseUrl);
        logger.info("Open page {}", Configuration.baseUrl);
    }

    protected MainPage loginInSite() {
        return new LoginPage().enterLoginData(ADMIN_LOGIN)
                .enterPasswordData(ADMIN_PASSWORD)
                .pressLogin();
    }

}
