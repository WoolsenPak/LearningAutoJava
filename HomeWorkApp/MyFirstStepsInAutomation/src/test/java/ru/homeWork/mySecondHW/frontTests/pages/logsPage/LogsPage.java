package ru.homeWork.mySecondHW.frontTests.pages.logsPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.mySecondHW.frontTests.pages.BasePage;
import ru.homeWork.mySecondHW.frontTests.pages.logsPage.models.LogsTableDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.testng.Assert.assertEquals;


public class LogsPage extends BasePage {

    private static final String EXPECTED_USER = "Admin User [Admin]";
    private static final String EXPECTED_IP = "172.18.0.1";
    private static final String ACTION_PATTERN = "Page Viewed: (%s)";

    private static final Logger logger = LoggerFactory.getLogger(LogsPage.class);

    private final LogsTable logsTable = new LogsTable();

    public LogsPage() {
        logger.info("Navigate to LogsPage");
    }

    public String getCurrentIpAddress() {
        return EXPECTED_IP;
    }


    public void checkFirstRow(LocalDateTime localDateTime, String currentIp, String expectedPage) {
        logger.info("Checking first row");

        LogsTableDto firstRow = logsTable.getFirstRow();

        assertEquals(firstRow.getIp(), currentIp,
                "Check that IP equals current IP: " + currentIp);

        String expectedAction = String.format(ACTION_PATTERN, expectedPage);
        assertEquals(firstRow.getAction(), expectedAction,
                "Check that action equals current action: " + expectedAction);

        assertEquals(firstRow.getUser(), EXPECTED_USER, "Check that user equals current user: " + EXPECTED_USER);

        LocalDate tableDate = firstRow.getDate();
        LocalDate navigationDate = localDateTime.toLocalDate();
        assertEquals(tableDate, navigationDate,
                String.format("Date logsPage [%s] equals real date [%s]",
                        tableDate, navigationDate));
    }

}

