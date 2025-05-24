package ru.homeWork.mySecondHW.api.cats.models;

import lombok.Getter;

import java.util.List;


@Getter
public class CatListResponseDto {
    private StatusDto status;
    private List<CatDto> data;
}