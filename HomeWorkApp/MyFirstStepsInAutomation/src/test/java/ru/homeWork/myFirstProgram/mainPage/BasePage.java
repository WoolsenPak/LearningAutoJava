package ru.homeWork.myFirstProgram.mainPage;

import ru.homeWork.myFirstProgram.components.BurgerMenu;
import ru.homeWork.myFirstProgram.elements.UiComponentFactory;

public class BasePage {

    protected BurgerMenu burgerMenu = UiComponentFactory.createBurgerMenu(BurgerMenu.SELF);

    public BurgerMenu burgerMenu() {
        return burgerMenu;
    }

    public LoginPage logout(){
        return burgerMenu.clickLogoutButton();
    }
}
