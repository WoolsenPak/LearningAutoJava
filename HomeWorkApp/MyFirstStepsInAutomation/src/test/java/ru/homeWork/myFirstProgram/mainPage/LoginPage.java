package ru.homeWork.myFirstProgram.mainPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.homeWork.myFirstProgram.elements.Input;
import ru.homeWork.myFirstProgram.elements.UiComponentFactory;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage{

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private static final By LOGIN = By.name("user-name");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.name("login-button");

    public LoginPage enterLoginData(String login){
        UiComponentFactory.createInput(LOGIN).fillData(login);
        return this;
    }

    public LoginPage enterPasswordData(String password){
        UiComponentFactory.createInput(PASSWORD).fillData(password);
        return this;
    }

    public MainPage clickLoginButton(){
        UiComponentFactory.createButton(LOGIN_BUTTON).click();
        return new MainPage();
    }






}
