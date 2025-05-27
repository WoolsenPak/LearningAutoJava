package ru.homeWork.mySecondHW.api.cats.models;

import lombok.Getter;


@Getter
public class CatResponseDto {
    private StatusDto status;
    private CatDto data;
}
