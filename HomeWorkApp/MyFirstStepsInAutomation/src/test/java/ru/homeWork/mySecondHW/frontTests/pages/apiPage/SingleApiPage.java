package ru.homeWork.mySecondHW.frontTests.pages.apiPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.elements.Button;
import ru.homeWork.mySecondHW.frontTests.elements.Input;

import ru.homeWork.mySecondHW.frontTests.elements.UiComponentFactory;
import ru.homeWork.mySecondHW.frontTests.entities.ApiEntity;
import ru.homeWork.mySecondHW.frontTests.pages.BasePage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;

public class SingleApiPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(SingleApiPage.class);
    public static final String ADD_TITLE_VALUE = "Add API Token";
    public static final String UPDATE_TITLE_VALUE = "%s - Update API Token";

    private static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");

    private final By API_TOKEN = By.cssSelector("input[disabled]");
    private final Input cosmeticName = UiComponentFactory.createInput(getInputByName("cosmetic_name"));
    private final Input ipAddress = UiComponentFactory.createInput(getInputByName("ip_address"));
    private final Button updateApiToken = UiComponentFactory.createButton(SUBMIT_BUTTON);
    private final Button saveApiToken = UiComponentFactory.createButton(SUBMIT_BUTTON);


    private final boolean isUpdateApiState;

    public SingleApiPage() {
        logger.info("Navigate to Add Api TokenPage");
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(ADD_TITLE_VALUE));
        isUpdateApiState = false;
    }

    public SingleApiPage(String apiToken, String name, String ipAddress) {
        String title = String.format(UPDATE_TITLE_VALUE, apiToken);
        logger.info("Navigate to Update Api TokenPage");
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(title));
        isUpdateApiState = true;
    }

    public SingleApiPage fillNewApiToken(ApiEntity apiEntity) {
        element(API_TOKEN).getText();
        cosmeticName.fillData(apiEntity.getName());
        ipAddress.fillData(apiEntity.getIpAddress());
        return this;
    }

    public SingleApiPage editApiToken(ApiEntity apiEntity) {
        if (!isUpdateApiState) {
            throw new InvalidElementStateException("Wrong Page State: Add New ApiToken");
        }
        cosmeticName.clear();
        cosmeticName.fillData(apiEntity.getName());
        return this;
    }

    public ApiPage confirmEditApiToken() {
        updateApiToken.click();
        return new ApiPage();
    }

    public MainPage saveNewApiToken() {
        saveApiToken.click();
        return new MainPage();
    }
}
