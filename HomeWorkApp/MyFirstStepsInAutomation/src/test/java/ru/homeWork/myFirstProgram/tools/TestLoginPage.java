package ru.homeWork.myFirstProgram.tools;

import org.testng.annotations.Test;
import ru.homeWork.myFirstProgram.mainPage.LoginPage;
import ru.homeWork.myFirstProgram.mainPage.MainPage;


public class TestLoginPage extends BaseTestClass{


    @Test
    public void loginAndLogoutTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.enterLoginData(ADMIN_LOGIN).
                enterPasswordData(ADMIN_PASSWORD).
                clickLoginButton();

        mainPage.clickBurgerMenu();
        mainPage.logout();
    }

}
