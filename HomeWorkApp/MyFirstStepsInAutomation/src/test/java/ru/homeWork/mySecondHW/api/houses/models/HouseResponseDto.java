package ru.homeWork.mySecondHW.api.houses.models;

import lombok.Getter;


@Getter
public class HouseResponseDto {
    private StatusDto status;
    private HouseDto data;
}
