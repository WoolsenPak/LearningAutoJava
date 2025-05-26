package ru.homeWork.mySecondHW.frontTests.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.frontTests.BaseTestClass;
import ru.homeWork.mySecondHW.frontTests.entities.ApiEntity;
import ru.homeWork.mySecondHW.frontTests.entities.ContactEntity;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.ApiPage;
import ru.homeWork.mySecondHW.frontTests.pages.apiPage.models.ApiTableDto;
import ru.homeWork.mySecondHW.frontTests.pages.cotactInfoPage.AddEditContactPage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.models.ContactTableDto;

import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.Map;

public class TestContactApi extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(TestContactApi.class);

    private final Faker faker = Faker.instance();
    private ContactEntity contactEntity;
    private ApiEntity apiEntity;
    private MainPage mainPage;

    private static final String API_URL = "http://localhost:12301/api.php";
    private static final String IP_ADDRESS = "172.18.0.1";

    @BeforeClass
    public void prepareCondition() {

        contactEntity = new ContactEntity()
                .withName(faker.elderScrolls().firstName())
                .withMiddleName(faker.elderScrolls().race())
                .withLastName(faker.elderScrolls().lastName())
                .withPhoneNumber(String.format("8%s", faker.number().digits(11)))
                .withMobileNumber(String.format("8%s", faker.number().digits(11)))
                .withEmail(String.format("email%s@test.com", faker.number().digits(10)))
                .withBirthDate(LocalDate.of(
                        faker.number().numberBetween(1900, 2025),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28)))
                .withAddress1(faker.address().firstName())
                .withAddress2(faker.address().lastName())
                .withCity(faker.address().city())
                .withCountry(faker.address().country())
                .withPostCode(faker.number().digits(6));

        apiEntity = new ApiEntity()
                .withName(String.format("name" + faker.number().digits(8)))
                .withIpAddress(IP_ADDRESS);
    }

    @Test
    public void testSendApiPhone(){

        mainPage = loginInSite();

        AddEditContactPage addEditContactPage = mainPage.goToAddContactPage();
        mainPage = addEditContactPage.fillContactData(contactEntity).saveContact();

        mainPage.findContact(contactEntity.getEmail());
        ContactTableDto contactFromTable = mainPage.getContactTable().getFirstTableContact();
        String mobileNumber = contactFromTable.getPhoneNumber();
        logger.info("MobileNumber is: {}", mobileNumber);

        ApiPage apiPage = mainPage.goToApiPage();
        mainPage = apiPage.goToAddApiPage()
                .fillNewApiToken(apiEntity)
                .saveNewApiToken();

        mainPage.goToApiPage();
        apiPage.findApi(apiEntity.getName());
        ApiTableDto apiFromTable = apiPage.getApiTable().getFirstRaw();
        String apiToken = apiFromTable.getApiToken();
        logger.info("ApiToken is: {}", apiToken);

        Response response = RestAssured.given()
                .queryParam("t", apiToken)
                .queryParam("m", "findNumber")
                .queryParam("q", mobileNumber)
                .when()
                .get(API_URL)
                .then()
                .statusCode(200)
                .extract()
                .response();

        Map<String, Object> responseBody = response.as(Map.class);

        assertThat(responseBody)
                .as("Check API response")
                .containsEntry("success", 1)
                .containsEntry("method", "findNumber")
                .containsEntry("query", contactEntity.getMobileNumber())
                .containsEntry("result", contactEntity.getName() + " " + contactEntity.getLastName())
                .containsEntry("result_message", "API call successful.");
    }

    @AfterClass()
    public void afterAction() {
         mainPage.logout();
    }
}
