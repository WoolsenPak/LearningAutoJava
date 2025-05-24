package ru.homeWork.mySecondHW.frontTests.pages.userPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.elements.Button;
import ru.homeWork.mySecondHW.frontTests.elements.Input;
import ru.homeWork.mySecondHW.frontTests.elements.UiComponentFactory;
import ru.homeWork.mySecondHW.frontTests.pages.BasePage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class DeleteUserPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DeleteUserPage.class);

    private static final By CONFIRM_CHECKBOX = By.name("confirm_delete");
    private static final By DELETE_BUTTON = By.name("submit");
    private static final String TITLE_VALUE = "%s [%s] - Delete User";

    private Button deleteButton = UiComponentFactory.createButton(DELETE_BUTTON);
    private Input confirmCheckBox = UiComponentFactory.createInput(CONFIRM_CHECKBOX);

    public DeleteUserPage(String name, String username) {
        logger.info("Navigate to DeleteUserPage [{}]", username);
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(String.format(TITLE_VALUE, name, username)));
    }

    public MainPage deleteContact() {
        confirmCheckBox.clickCheckBox();
        deleteButton.click();
        return new MainPage();
    }

}