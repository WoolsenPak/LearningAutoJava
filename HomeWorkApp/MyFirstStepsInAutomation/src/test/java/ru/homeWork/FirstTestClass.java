package ru.homeWork;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class FirstTestClass {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "http://localhost:12301/";
        Configuration.headless = false;
    }


    @Test
    public void loginInSite() {
        open(Configuration.baseUrl);

        $(By.name("username")).click();
        $(By.name("username")).sendKeys("admin");

        $(By.name("password")).click();
        $(By.name("password")).sendKeys("root");
        $(By.name("submit")).click();

        String successPopup = "div[role='alert']";
        String expectedSuccessLoginPopupText = "You have been logged in successfully.";

        String actualSuccessLoginPopupTest = $(successPopup).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualSuccessLoginPopupTest, expectedSuccessLoginPopupText);

    }

    @Test
    public void checkHeader() {
        open(Configuration.baseUrl);

        $(By.name("username")).click();
        $(By.name("username")).sendKeys("admin");

        $(By.name("password")).click();
        $(By.name("password")).sendKeys("root");
        $(By.name("submit")).click();

        String navbar = "li[data-testid = 'navbar_item']";

        ElementsCollection navigationButtons = $$(By.cssSelector(navbar));
        navigationButtons.get(navigationButtons.size() - 2).click();

        String ApiH2 = "h2";
        String expectedApiH2 = "API    ";
        String actualApiH2 = $(ApiH2).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualApiH2, expectedApiH2);

        navigationButtons.get(navigationButtons.size() - 3).click();

        String LogsH2 = "h2";
        String expectedLogsH2 = "Logs    ";
        String actualLogsH2 = $(LogsH2).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualLogsH2, expectedLogsH2);

        navigationButtons.get(navigationButtons.size() - 4).click();

        String UsersH2 = "h2";
        String expectedUsersH2 = "Users    ";
        String actualUsersH2 = $(UsersH2).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualUsersH2, expectedUsersH2);

        navigationButtons.get(navigationButtons.size() - 5).click();

        String AddressH2 = "h2";
        String expectedAddressH2 = "Address Book    ";
        String actualAddressH2 = $(AddressH2).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualAddressH2, expectedAddressH2);

        $(By.cssSelector("div[class = 'navbar-header']")).click();
    }

    @Test
    public void logoutSite() {

        String successPopup = "div[role='alert']";
        String expectedSuccessLogoutPopupText = "You have been logged out successfully.";

        String logoutSelector = "li[data-testid = 'navbar_item']";

        ElementsCollection navigationButtons = $$(By.cssSelector(logoutSelector));
        navigationButtons.get(navigationButtons.size() - 1).click();
        String actualSuccessLogoutPopupTest = $(successPopup).shouldHave(Condition.visible).innerText();
        Assert.assertEquals(actualSuccessLogoutPopupTest, expectedSuccessLogoutPopupText);


    }
}

