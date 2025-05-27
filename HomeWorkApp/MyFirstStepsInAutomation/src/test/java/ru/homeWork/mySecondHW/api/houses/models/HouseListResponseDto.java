package ru.homeWork.mySecondHW.api.houses.models;

import lombok.Getter;

import java.util.List;

@Getter
public class HouseListResponseDto {
    private StatusDto status;
    private List<HouseDto> data;
}
