package ru.homeWork.mySecondHW.frontTests.pages;

import org.openqa.selenium.By;
import ru.homeWork.mySecondHW.frontTests.components.NavigationBar;
import ru.homeWork.mySecondHW.frontTests.components.PagePopup;
import ru.homeWork.mySecondHW.frontTests.elements.UiComponentFactory;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.ApiPage;
import ru.homeWork.mySecondHW.frontTests.pages.logsPage.LogsPage;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.UserPage;

public class BasePage {

    protected static final By TITLE = By.cssSelector("h2");

    protected NavigationBar navigationBar = UiComponentFactory.createNavigationBar(NavigationBar.SELF);
    protected final PagePopup pagePopup = UiComponentFactory.createPagePopup(PagePopup.SELF);

    protected static By getInputByName(String name) {
        return By.cssSelector(String.format("input[name='%s']", name));
    }

    public PagePopup getPagePopup(){
        return pagePopup;
    }

    public LoginPage logout() {
        return navigationBar.clickLogoutButton();
    }

    public UserPage goToUserPage() {
        return navigationBar.clickUserButton();
    }

    public LogsPage goToLogsPage() {
        return navigationBar.clickLogsButton();
    }

    public ApiPage goToApiPage() {
        return navigationBar.clickApiButton();
    }
}