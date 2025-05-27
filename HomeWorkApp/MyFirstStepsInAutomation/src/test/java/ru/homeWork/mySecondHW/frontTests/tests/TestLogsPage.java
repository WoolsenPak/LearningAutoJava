package ru.homeWork.mySecondHW.frontTests.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.frontTests.BaseTestClass;

import ru.homeWork.mySecondHW.frontTests.pages.logsPage.LogsPage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;

import java.time.LocalDateTime;


public class TestLogsPage extends BaseTestClass{
    private MainPage mainPage;

    @Test
    public void testLogsPage() throws InterruptedException {

        mainPage = loginInSite();
        Thread.sleep(500);
        LogsPage logsPage = mainPage.goToLogsPage();

        LocalDateTime testStartTime = LocalDateTime.now();
        String currentIp = logsPage.getCurrentIpAddress();

        logsPage.checkFirstRow(testStartTime, currentIp, "Logs");
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}
