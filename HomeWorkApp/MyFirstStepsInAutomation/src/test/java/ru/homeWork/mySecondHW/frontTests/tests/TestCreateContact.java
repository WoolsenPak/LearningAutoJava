package ru.homeWork.mySecondHW.frontTests.tests;

import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.frontTests.BaseTestClass;
import ru.homeWork.mySecondHW.frontTests.components.PagePopup;
import ru.homeWork.mySecondHW.frontTests.elements.Table;
import ru.homeWork.mySecondHW.frontTests.entities.ContactEntity;
import ru.homeWork.mySecondHW.frontTests.pages.cotactInfoPage.AddEditContactPage;
import ru.homeWork.mySecondHW.frontTests.pages.cotactInfoPage.ContactInfoPage;
import ru.homeWork.mySecondHW.frontTests.pages.cotactInfoPage.ContactInfoTitle;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.models.ContactTableDto;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


public class TestCreateContact extends BaseTestClass {

    private final Faker faker = Faker.instance();

    private ContactEntity contactForSave;
    private ContactEntity updatedContact;

    private MainPage mainPage;

    @BeforeClass
    public void prepareCondition() {
        contactForSave = new ContactEntity();
        contactForSave.withName(faker.elderScrolls().firstName())
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

        updatedContact = new ContactEntity();
        updatedContact.withName(faker.elderScrolls().firstName())
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

    }

    @Test(priority = 1)
    public void testCreateContact() {
        mainPage = loginInSite();
        AddEditContactPage addEditContactPage = mainPage.goToAddContactPage();
        mainPage = addEditContactPage.fillContactData(contactForSave).saveContact();

        mainPage.findContact(contactForSave.getEmail());
        ContactTableDto firstContact = mainPage.getContactTable().getFirstTableContact();

        assertThat(firstContact)
                .as("Check contact exists in table")
                .isNotNull();
    }

    @Test(priority = 2, dependsOnMethods = "testCreateContact")
    public void testVerifyContactTable() {
        ContactTableDto firstContact = mainPage.getContactTable().getFirstTableContact();

        assertThat(firstContact.getName())
                .as("Check Contact FullName")
                .isEqualTo(contactForSave.getFullName());
        assertThat(firstContact.getCity())
                .as("Check Contact City")
                .isEqualTo(contactForSave.getCity());
        assertThat(firstContact.getPhoneNumber())
                .as("Check Contact MobilePhone")
                .isEqualTo(contactForSave.getMobileNumber());
        assertThat(firstContact.getEmail())
                .as("Check Contact Email")
                .isEqualTo(contactForSave.getEmail());
    }

    @Test(priority = 3, dependsOnMethods = "testVerifyContactTable")
    public void testVerifyContactInfoPage() {
        ContactInfoPage contactInfoPage = mainPage.getContactTable().navigateToFirstTableRowContactPage();

        String actualFullName = contactInfoPage.getValueByTitle(ContactInfoTitle.FULL_NAME);
        String actualHomePhone = contactInfoPage.getValueByTitle(ContactInfoTitle.HOME_NUMBER);
        String actualMobilePhone = contactInfoPage.getValueByTitle(ContactInfoTitle.MOBILE_NUMBER);
        String actualEmail = contactInfoPage.getValueByTitle(ContactInfoTitle.EMAIL);
        String actualBirthDate = contactInfoPage.getValueByTitle(ContactInfoTitle.BIRTH_DATE);
        String actualAddress = contactInfoPage.getValueByTitle(ContactInfoTitle.ADDRESS);

        SoftAssertions.assertSoftly(sa -> {
            sa.assertThat(actualFullName)
                    .as("Check Contact FullName on ContactInfo Page")
                    .isEqualTo(contactForSave.getFullName());
            sa.assertThat(actualHomePhone)
                    .as("Check Contact Home Phone on ContactInfo Page")
                    .isEqualTo(contactForSave.getPhoneNumber());
            sa.assertThat(actualMobilePhone)
                    .as("Check Contact Mobile Phone on ContactInfo Page")
                    .isEqualTo(contactForSave.getMobileNumber());
            sa.assertThat(actualEmail)
                    .as("Check Contact Email on ContactInfo Page")
                    .isEqualTo(contactForSave.getEmail());
            sa.assertThat(actualBirthDate)
                    .as("Check Contact Date on ContactInfo Page")
                    .contains(contactForSave.getFullBirthDate());
            sa.assertThat(actualAddress)
                    .as("Check Contact Home Phone on ContactInfo Page")
                    .isEqualTo(contactForSave.getFullAddress());

            contactInfoPage.navigateToUpdateContact();
        });
    }

    @Test(priority = 4, dependsOnMethods = "testVerifyContactInfoPage")
    public void testUpdateContact() {
        AddEditContactPage updateContactPage = new AddEditContactPage(contactForSave.getFullName());
        mainPage = updateContactPage.fillContactData(updatedContact).saveContact();

        mainPage.findContact(updatedContact.getEmail());
        ContactTableDto updatedTableContact = mainPage.getContactTable().getFirstTableContact();

        SoftAssertions.assertSoftly(sa -> {
            sa.assertThat(updatedTableContact)
                    .as("Check that updated contact exists")
                    .isNotNull();
            sa.assertThat(updatedTableContact.getName())
                    .as("Check updated FullName")
                    .isEqualTo(updatedContact.getFullName());
            sa.assertThat(updatedTableContact.getCity())
                    .as("Check updated City")
                    .isEqualTo(updatedContact.getCity());
            sa.assertThat(updatedTableContact.getPhoneNumber())
                    .as("Check updated MobilePhone")
                    .isEqualTo(updatedContact.getMobileNumber());
            sa.assertThat(updatedTableContact.getEmail())
                    .as("Check updated Email")
                    .isEqualTo(updatedContact.getEmail());
        });

        ContactInfoPage contactInfoPage = mainPage.getContactTable().navigateToFirstTableRowContactPage();
        String actualFullName = contactInfoPage.getValueByTitle(ContactInfoTitle.FULL_NAME);
        String actualHomePhone = contactInfoPage.getValueByTitle(ContactInfoTitle.HOME_NUMBER);
        String actualMobilePhone = contactInfoPage.getValueByTitle(ContactInfoTitle.MOBILE_NUMBER);
        String actualEmail = contactInfoPage.getValueByTitle(ContactInfoTitle.EMAIL);
        String actualBirthDate = contactInfoPage.getValueByTitle(ContactInfoTitle.BIRTH_DATE);
        String actualAddress = contactInfoPage.getValueByTitle(ContactInfoTitle.ADDRESS);

        SoftAssertions.assertSoftly(sa -> {
            sa.assertThat(actualFullName)
                    .as("Check FullName on ContactInfo Page")
                    .isEqualTo(updatedContact.getFullName());
            sa.assertThat(actualHomePhone)
                    .as("Check HomePhone on ContactInfo Page")
                    .isEqualTo(updatedContact.getPhoneNumber());
            sa.assertThat(actualMobilePhone)
                    .as("Check MobilePhone on ContactInfo Page")
                    .isEqualTo(updatedContact.getMobileNumber());
            sa.assertThat(actualEmail)
                    .as("Check Email on ContactInfo Page")
                    .isEqualTo(updatedContact.getEmail());
            sa.assertThat(actualBirthDate)
                    .as("Check Date on ContactInfo Page")
                    .contains(updatedContact.getFullBirthDate());
            sa.assertThat(actualAddress)
                    .as("Check Address on ContactInfo Page")
                    .isEqualTo(updatedContact.getFullAddress());
        });
        contactForSave = updatedContact;
        mainPage = contactInfoPage.navigateToDeleteContact().deleteContact();

    }

    @Test(priority = 5, dependsOnMethods = "testUpdateContact")
    public void testDeleteContact() {
        String deleteTextPopup = mainPage.getPagePopup().getText();
        assertThat(deleteTextPopup)
                .as("Check Delete Text Popup")
                .isEqualTo(PagePopup.DELETE_CONTACT_TEXT);

        mainPage.findContact(contactForSave.getEmail());
        String emptyRowText = mainPage.getContactTable().getEmptyRowText();
        assertThat(emptyRowText)
                .as("Check Empty Row In Contact Table")
                .isEqualTo(Table.EMPTY_ROW_TEXT);
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}