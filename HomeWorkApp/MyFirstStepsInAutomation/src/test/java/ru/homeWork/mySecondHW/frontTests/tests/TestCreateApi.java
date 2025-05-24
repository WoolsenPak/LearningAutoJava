package ru.homeWork.mySecondHW.frontTests.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.frontTests.components.PagePopup;
import ru.homeWork.mySecondHW.frontTests.entities.ApiEntity;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.ApiPage;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.DeleteApiPage;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.SingleApiPage;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.models.ApiTableDto;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;
import ru.homeWork.mySecondHW.frontTests.BaseTestClass;

import static org.assertj.core.api.Assertions.assertThat;


public class TestCreateApi extends BaseTestClass {

    private final Faker faker = Faker.instance();
    private ApiEntity apiEntity;
    private MainPage mainPage;

    @BeforeClass
    public void prepareCondition() {
        apiEntity = new ApiEntity();
        apiEntity.withName(String.format("name" + faker.number().digits(8)))
                .withIpAddress("172.18.0.33");
    }

    @Test(priority = 1)
    public void testCreateApiToken() {
        mainPage = loginInSite();
        ApiPage apiPage = mainPage.goToApiPage();

        mainPage = apiPage.goToAddApiPage()
                .fillNewApiToken(apiEntity)
                .saveNewApiToken();

        assertThat(mainPage.getPagePopup().getText())
                .as("Check Popup Text Success Add Api")
                .isEqualTo(PagePopup.SUCCESS_API_CREATE);
    }

    @Test(priority = 2, dependsOnMethods = "testCreateApiToken")
    public void testVerifyCreatedApiToken() {
        ApiPage apiPage = mainPage.goToApiPage();
        apiPage.findApi(apiEntity.getName());

        ApiTableDto createdApi = apiPage.getApiTable().getFirstRaw();

        assertThat(createdApi.getName())
                .as("Check Name")
                .isEqualTo(apiEntity.getName());
        assertThat(createdApi.getAuthorisedIp())
                .as("Check Authorised IP")
                .isEqualTo(apiEntity.getIpAddress());
    }

    @Test(priority = 3, dependsOnMethods = "testVerifyCreatedApiToken")
    public void testUpdateApiToken() {
        ApiPage apiPage = mainPage.goToApiPage();
        String newName = "updated" + faker.number().digits(8);

        SingleApiPage updatedPage = apiPage.getApiTable().updateApiByRow(0);
        apiPage = updatedPage.editApiToken(new ApiEntity().withName(newName)).confirmEditApiToken();

        assertThat(mainPage.getPagePopup().getText())
                .as("Check update Api")
                .isEqualTo(PagePopup.SUCCESS_API_UPDATE);

        apiPage.findApi(newName);
        ApiTableDto updatedApi = apiPage.getApiTable().getFirstRaw();
        assertThat(updatedApi.getName())
                .as("Check Name")
                .isEqualTo(newName);

    }

    @Test(priority = 4, dependsOnMethods = "testUpdateApiToken")
    public void testDeleteApiToken() {
        ApiPage apiPage = mainPage.goToApiPage();

        DeleteApiPage deleteApiPage = apiPage.getApiTable().deleteApiByRow(0);
        mainPage = deleteApiPage.deleteContact();
        String successDeleteApiText = mainPage.getPagePopup().getText();
        assertThat(successDeleteApiText)
                .as("Check Popup Text Success Delete Api")
                .isEqualTo(PagePopup.SUCCESS_API_DELETE);

        apiPage = mainPage.goToApiPage();
        apiPage.findApi(apiEntity.getName());
        String emptyRowText = apiPage.getApiTable().getEmptyRowText();
        assertThat(emptyRowText)
                .as("Check Empty Row In Api Table")
                .isEqualTo("No data available in table");
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}
