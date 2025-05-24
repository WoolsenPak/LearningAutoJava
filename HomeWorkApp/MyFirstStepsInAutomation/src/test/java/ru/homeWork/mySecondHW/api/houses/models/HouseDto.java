package ru.homeWork.mySecondHW.api.houses.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import ru.homeWork.mySecondHW.api.cats.models.CatDto;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    private String name;
    private List<CatDto> cats;


}