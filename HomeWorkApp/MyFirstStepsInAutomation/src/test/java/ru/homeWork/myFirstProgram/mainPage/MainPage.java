package ru.homeWork.myFirstProgram.mainPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.homeWork.myFirstProgram.components.BurgerMenu;
import ru.homeWork.myFirstProgram.elements.UiComponentFactory;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage{
private static final Logger logger = LoggerFactory.getLogger(MainPage.class);
private static final By BURGER_MENU = By.cssSelector("#react-burger-menu-btn");
private static final By APP_LOGO = By.cssSelector("#header_container > div.primary_header > div.header_label > div");
private static final By SHOPPING_CARD = By.id("shopping_cart_container");
private static final By CART_TITLE = By.cssSelector("[class='title']");


    public MainPage() {
        logger.info("Navigate to MainPage");
    }


    public void checkLogo(){
    String expectedText = "Swag Labs";
    String actualText = $(APP_LOGO).shouldHave(Condition.visible).innerText();
    Assert.assertEquals(expectedText, actualText);
    }

    public BurgerMenu clickBurgerMenu (){
    UiComponentFactory.createButton(BURGER_MENU).click();
    return burgerMenu;
    }

    public void checkShoppingCart(){
    String expectedText = "Your Cart";
    $(SHOPPING_CARD).click();
    String actualText = $(CART_TITLE).should(Condition.visible).innerText();
    Assert.assertEquals(expectedText, actualText);
    }
}
