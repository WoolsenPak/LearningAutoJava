package ru.homeWork.mySecondHW.frontTests.components;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.homeWork.mySecondHW.frontTests.elements.UiComponent;

public class PagePopup extends UiComponent {

    public static final String SUCCESS_POPUP_TEXT = "You have been logged in successfully.";
    public static final String SUCCESS_POPUP_COLOR = "linear-gradient(rgb(223, 240, 216) 0px, rgb(200, 229, 188) 100%)";
    public static final String SUCCESS_USER_CREATE = "New user has been successfully added.";
    public static final String SUCCESS_USER_DELETE = "User successfully deleted.";
    public static final String SUCCESS_USER_UPDATE = "Full name/username has been updated successfully.";
    public static final String SUCCESS_USER_PASSWORD_UPDATE = "Password successfully updated.";
    public static final String SUCCESS_API_DELETE = "API token has been successfully deleted.";
    public static final String SUCCESS_API_CREATE = "A new API token has been successfully added.";
    public static final String SUCCESS_API_UPDATE = "API token has been successfully updated.";
    public static final String NON_LOGIN_MESSAGE = "You must be authenticated to view that page. Please log in.";
    public static final String LOGOUT_POPUP_TEXT = "You have been logged out successfully.";
    public static final String UPDATE_CONTACT_TEXT = "Contact has been successfully updated.";
    public static final String DELETE_CONTACT_TEXT = "Contact has been successfully deleted.";

    public static final By SELF = By.cssSelector("div[role='alert']");

    public PagePopup(By selfSelector) {
        super(selfSelector);
    }

    public String getText() {
        return element.shouldBe(Condition.visible).getText();
    }

    public String getBackgroundColor() {
        return element.shouldBe(Condition.visible).getCssValue("background-image");
    }
}