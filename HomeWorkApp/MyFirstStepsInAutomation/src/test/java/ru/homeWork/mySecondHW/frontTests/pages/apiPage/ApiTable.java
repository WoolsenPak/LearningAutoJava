package ru.homeWork.mySecondHW.frontTests.pages.apiPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.elements.Table;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.models.ApiTableDto;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.models.ApiAction;


public class ApiTable extends Table {

    private static final By SELF = By.cssSelector("table[id='api']");
    private static final By EMPTY_ROW = By.cssSelector(".dataTables_empty");

    private static final Logger logger = LoggerFactory.getLogger(ApiTable.class);

    public ApiTable() {
        super(SELF);
    }

    public String getEmptyRowText() {
        return element.find(EMPTY_ROW).getText();
    }

    public ApiTableDto getApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        return ApiTableDto.builder()
                .apiToken(rowsData.get(0).getText())
                .name(rowsData.get(1).getText())
                .authorisedIp(rowsData.get(2).getText())
                .build();
    }

    public ApiTableDto getFirstRaw() {
        return getApiByRow(0);
    }

    public SingleApiPage updateApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        String apiToken = rowsData.get(0).getText();
        String name = rowsData.get(1).getText();
        String authorisedIp = rowsData.get(2).getText();
        SelenideElement updateApiButton = rows.get(rowNumber).findAll("a").filter(Condition.text(ApiAction.UPDATE.getValue())).first();
        String updateApiButtonText = updateApiButton.getText();
        updateApiButton.click();
        logger.info("User click [{}] for token [{}]", updateApiButtonText, apiToken);
        return new SingleApiPage(apiToken, name, authorisedIp);
    }

    public DeleteApiPage deleteApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        String apiToken = rowsData.get(0).getText();
        String name = rowsData.get(1).getText();
        String authorisedIp = rowsData.get(2).getText();
        SelenideElement updateApiButton = rows.get(rowNumber).findAll("a").filter(Condition.text(ApiAction.DELETE.getValue())).first();
        String updateApiButtonText = updateApiButton.getText();
        updateApiButton.click();
        logger.info("User click [{}] for user [{}]", updateApiButtonText, apiToken);
        return new DeleteApiPage(apiToken, name, authorisedIp);
    }
}