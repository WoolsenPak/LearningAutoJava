package ru.homeWork.mySecondHW.frontTests.pages.apiPage.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiTableDto {

    private String apiToken;
    private String name;
    private String authorisedIp;
}
