package ru.homeWork.mySecondHW.frontTests.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.frontTests.BaseTestClass;
import ru.homeWork.mySecondHW.frontTests.components.PagePopup;
import ru.homeWork.mySecondHW.frontTests.elements.Table;
import ru.homeWork.mySecondHW.frontTests.entities.UserEntity;
import ru.homeWork.mySecondHW.frontTests.pages.mainPage.MainPage;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.DeleteUserPage;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.SingleUserPage;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.UserPage;
import ru.homeWork.mySecondHW.frontTests.pages.userPage.models.UserTableDto;


import static org.assertj.core.api.Assertions.assertThat;

public class TestCreateUsers extends BaseTestClass {

    private final Faker faker = Faker.instance();

    private UserEntity userEntity;

    private MainPage mainPage;
    private String newName;
    private String newPassword;

    @BeforeClass
    public void prepareCondition() {
        userEntity = new UserEntity();
        userEntity.withFullName(faker.artist().name())
                .withUsername(String.format("user" + faker.number().digits(8)))
                .withPassword(String.format("Password" + faker.number().digits(8)));
        newName = "updated-" + faker.number().digits(8);
        newPassword = "NewPassword" +faker.number().digits(8);
    }

    @Test(priority = 1)
    public void testCreateUser() {
        mainPage = loginInSite();
        UserPage userPage = mainPage.goToUserPage();
        mainPage = userPage.goToAddUserPage().fillNewUserData(userEntity).saveNewUser();
        String successUserCreateText = mainPage.getPagePopup().getText();
        assertThat(successUserCreateText)
                .as("Check Popup Text Success Create User")
                .isEqualTo(PagePopup.SUCCESS_USER_CREATE);

        mainPage.goToUserPage();
        userPage.findUser(userEntity.getUsername());
        UserTableDto firstUser = userPage.getUserTable().getFirstTableUser();

        assertThat(firstUser.getName())
                .as("Check User Name")
                .isEqualTo(userEntity.getFullName());
        assertThat(firstUser.getUsername())
                .as("Check User UserName")
                .isEqualTo(userEntity.getUsername());

    }

    @Test(priority = 2, dependsOnMethods = "testCreateUser")
    public void testUpdateUser() {
        UserPage userPage = mainPage.goToUserPage();
        userPage.findUser(userEntity.getUsername());
        UserEntity updatedUserEntity = new UserEntity().withUsername(newName);

        SingleUserPage updatedPage = userPage.getUserTable().updateUserByRow(0);
        userPage = updatedPage.editUserName(updatedUserEntity).confirmChangeUserName();

        String successUpdateText = mainPage.getPagePopup().getText();
        assertThat(successUpdateText)
                .as("Check update User")
                .isEqualTo(PagePopup.SUCCESS_USER_UPDATE);

        userPage.findUser(newName);
        UserTableDto updatedUser = userPage.getUserTable().getFirstTableUser();
        assertThat(updatedUser.getUsername())
                .as("Check UserName")
                .isEqualTo(newName);

        UserEntity passwordUpdateEntity = new UserEntity()
                .withPassword(newPassword);
        updatedPage = userPage.getUserTable().updateUserByRow(0);
        userPage = updatedPage.editUserPassword(passwordUpdateEntity).confirmChangeUserPassword();
        assertThat(mainPage.getPagePopup().getText())
                .as("Check update UserPassword")
                .isEqualTo(PagePopup.SUCCESS_USER_PASSWORD_UPDATE);
    }

    @Test(priority = 3, dependsOnMethods = "testUpdateUser")
    public void testDeleteUser() {
        UserPage userPage = mainPage.goToUserPage();
        userPage.findUser(newName);
        DeleteUserPage deleteUserPage = userPage.getUserTable().deleteUserByRow(0);
        mainPage = deleteUserPage.deleteContact();
        String successDeleteUserText = mainPage.getPagePopup().getText();
        assertThat(successDeleteUserText)
                .as("Check Popup Text Success Delete User")
                .isEqualTo(PagePopup.SUCCESS_USER_DELETE);

        userPage = mainPage.goToUserPage();
        userPage.findUser(userEntity.getUsername());
        String emptyRowText = userPage.getUserTable().getEmptyRowText();
        assertThat(emptyRowText)
                .as("Check Empty Row In User Table")
                .isEqualTo(Table.EMPTY_ROW_TEXT);
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}