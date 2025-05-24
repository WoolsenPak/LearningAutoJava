package ru.homeWork.mySecondHW.frontTests.pages.apiPage;

import lombok.Getter;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.elements.Button;
import ru.homeWork.mySecondHW.frontTests.elements.Input;
import ru.homeWork.mySecondHW.frontTests.elements.UiComponentFactory;
import ru.homeWork.mySecondHW.frontTests.pages.BasePage;


public class ApiPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ApiPage.class);

    private static final By ADD_API_BUTTON = By.cssSelector("a[type='button']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");

    private final Button addApiButton = UiComponentFactory.createButton(ADD_API_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);

    @Getter
    private final ApiTable apiTable = new ApiTable();

    public ApiPage() {
        logger.info("Navigate to ApiPage");
    }

    public ApiPage findApi(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public SingleApiPage goToAddApiPage() {
        addApiButton.click();
        return new SingleApiPage();
    }

}