package ru.homeWork.mySecondHW.frontTests.pages.userPage.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiAction {
    UPDATE("Update"),
    DELETE("Delete");

    private final String value;
}