package ru.homeWork.myFirstProgram.elements;

import org.openqa.selenium.By;
import ru.homeWork.myFirstProgram.components.BurgerMenu;

public final class UiComponentFactory {

    public static Input createInput(By path) {
        return new Input(path);
    }

    public static Button createButton(By path) {
        return new Button(path);
    }

    public static BurgerMenu createBurgerMenu (By path){
        return new BurgerMenu (path);
    }
}
