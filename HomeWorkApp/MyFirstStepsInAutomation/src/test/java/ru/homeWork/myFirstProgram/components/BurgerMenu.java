package ru.homeWork.myFirstProgram.components;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ru.homeWork.myFirstProgram.elements.UiComponent;
import ru.homeWork.myFirstProgram.mainPage.LoginPage;
import ru.homeWork.myFirstProgram.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class BurgerMenu extends UiComponent {

    public static final By SELF = By.cssSelector("div[class = 'bm-menu-wrap']");
    public static final By ALL_ITEMS = By.cssSelector("a[id= 'inventory_sidebar_link']");
    public static final By ABOUT = By.cssSelector("a[id= 'about_sidebar_link");
    public static final By LOGOUT = By.cssSelector("a[id= 'logout_sidebar_link");
    public static final By RESET_APP_STATE = By.cssSelector("a[id= 'reset_sidebar_link");

    public BurgerMenu(By Selector) {
        super(Selector);
    }

    public LoginPage clickLogoutButton(){
        $(LOGOUT).click();
        return new LoginPage();
    }

}
