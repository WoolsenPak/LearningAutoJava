package ru.homeWork.mySecondHW.frontTests.entities;

import lombok.Getter;

@Getter
public class ApiEntity {
    private String Name;
    private String ipAddress;
    private String apiToken;

    public ApiEntity withName(String data) {
        this.Name = data;
        return this;
    }

    public ApiEntity withIpAddress(String data) {
        this.ipAddress = data;
        return this;
    }
    public ApiEntity withApiToken(String data) {
        this.apiToken = data;
        return this;
    }
}
