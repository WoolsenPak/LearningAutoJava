package ru.homeWork.mySecondHW.frontTests.pages.apiPage;

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

public class DeleteApiPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DeleteApiPage.class);

    private static final By CONFIRM_CHECKBOX = By.name("confirm_delete");
    private static final By DELETE_BUTTON = By.name("submit");
    private static final String TITLE_VALUE = "%s - Delete User";

    private final Button deleteButton = UiComponentFactory.createButton(DELETE_BUTTON);
    private final Input confirmCheckBox = UiComponentFactory.createInput(CONFIRM_CHECKBOX);

    public DeleteApiPage(String apiToken, String name, String authorisedIp) {
        logger.info("Navigate to DeleteUserPage [{}]", apiToken);
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(String.format(apiToken, TITLE_VALUE)));
    }

    public MainPage deleteContact() {
        confirmCheckBox.clickCheckBox();
        deleteButton.click();
        return new MainPage();
    }

}