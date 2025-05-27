package ru.homeWork.mySecondHW.frontTests.pages.logsPage;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.homeWork.mySecondHW.frontTests.pages.logsPage.models.LogsTableDto;
import ru.homeWork.mySecondHW.frontTests.elements.Table;

public class LogsTable extends Table {

    private static final By SELF = By.cssSelector("table[id='logs']");

    public LogsTable() {
        super(SELF);
    }

    public LogsTableDto getLogsByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        return LogsTableDto.builder()
                .date(rowsData.get(0).getText())
                .action(rowsData.get(1).getText())
                .user(rowsData.get(2).getText())
                .ip(rowsData.get(3).getText())
                .build();
    }

    public LogsTableDto getFirstRow() {
        return getLogsByRow(0);
    }

}
