package ru.homeWork.mySecondHW.frontTests.pages.mainPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.components.PagePopup;
import ru.homeWork.mySecondHW.frontTests.elements.Button;
import ru.homeWork.mySecondHW.frontTests.elements.Input;
import ru.homeWork.mySecondHW.frontTests.elements.UiComponentFactory;
import ru.homeWork.mySecondHW.frontTests.pages.BasePage;
import ru.homeWork.mySecondHW.frontTests.pages.cotactInfoPage.AddEditContactPage;

public class MainPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    private static final By ADD_CONTACT_BUTTON = By.cssSelector("a[data-testid='add_contact']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");

    private final ContactTable contactTable = new ContactTable();
    private final Button addContactButton = UiComponentFactory.createButton(ADD_CONTACT_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);

    public MainPage() {
        logger.info("Navigate to MainPage");
    }

    public MainPage findContact(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public ContactTable getContactTable() {
        return contactTable;
    }

    public PagePopup getPagePopup() {
        return pagePopup;
    }

    public AddEditContactPage goToAddContactPage() {
        addContactButton.click();
        return new AddEditContactPage();
    }
}