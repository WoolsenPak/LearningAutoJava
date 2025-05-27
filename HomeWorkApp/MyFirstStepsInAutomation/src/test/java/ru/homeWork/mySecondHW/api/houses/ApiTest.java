package ru.homeWork.mySecondHW.api.houses;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.homeWork.mySecondHW.api.cats.CatConnector;
import ru.homeWork.mySecondHW.api.cats.models.CatDto;
import ru.homeWork.mySecondHW.api.houses.models.*;


import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest {

    private static final String NEW_NAME_TEMPLATE = "House_%s";
    private static final String CHANGE_TEMPLATE = "Change_%s";
    private static final int SUCCESS_STATUS = 1;
    private static final int COUNT_OF_GENERATED_HOUSES = 2;

    private final HouseConnector houseConnector = new HouseConnector();
    private final CatConnector catConnector = new CatConnector();

    private HouseDto houseEntity;
    private CatDto catEntity;

    @BeforeClass
    private void precondition() {
        List<CatDto> catList = catConnector.getCatList();
        catEntity = catList.stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Could not find existing cat"));

        houseEntity = HouseDto.builder()
                .name(String.format(NEW_NAME_TEMPLATE, System.currentTimeMillis()))
                .build();
    }

    @Test(priority = 1)
    public void apiDeleteAllHousesTest() {
        StatusDto statusDeleteAllHouses = houseConnector.deleteAllHouses();

        assertThat(statusDeleteAllHouses.getStatus())
                .as("Check Delete Status")
                .isEqualTo(SUCCESS_STATUS);
    }

    @Test(priority = 2)
    public void apiGenerateNewHousesTest() {
        List<HouseDto> houseList = houseConnector.generateNewHouses();

        List<String> houseNameList = houseList.stream()
                .map(HouseDto::getName)
                .toList();

        assertThat(houseNameList)
                .as("Check generate new houses")
                .hasSize(COUNT_OF_GENERATED_HOUSES);
    }

    @Test(priority = 3)
    public void apiCreateHouseTest() {
        HouseDto actualHouse = houseConnector.createNewHouses(houseEntity);

        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(actualHouse.getName())
                            .as("Check create House Name")
                            .isEqualTo(houseEntity.getName());
                }
        );
        houseEntity.setId(actualHouse.getId());
    }

    @Test(priority = 4)
    public void apiAvailableHouseInListTest() {
        List<HouseDto> houseList = houseConnector.getHouseList();

        assertThat(houseList)
                .as("Check available House List")
                .isNotNull();

        List<String> housesNameList = houseList.stream()
                .map(HouseDto::getName)
                .toList();

        assertThat(housesNameList)
                .as("Check available expected house")
                .contains(houseEntity.getName());
    }

    @Test(priority = 5)
    public void apiAvailableHouseTest() {
        HouseDto actualHouse = houseConnector.getHouseById(houseEntity.getId());

        assertThat(actualHouse)
                .as("Full Check Create House")
                .usingRecursiveComparison()
                .isEqualTo(houseEntity);
    }

    @Test(priority = 6)
    public void apiAddCatInHouseTest() {
        StatusDto updatedHouse = houseConnector.inputHouseIdAndCatId(
                houseEntity.getId(),
                catEntity.getId());

        HouseDto actualHouse = houseConnector.getHouseById(houseEntity.getId());

        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(updatedHouse.getStatus())
                            .as("Check status")
                            .isEqualTo(1);
                    softAssertions.assertThat(actualHouse.getCats())
                            .as("Check exist cat in this house")
                            .extracting(CatDto::getId)
                            .containsExactly(catEntity.getId());
                }
        );
    }

    @Test(priority = 7)
    public void apiEditHouseTest() {
        String expectedName = (String.format(CHANGE_TEMPLATE, houseEntity.getName()));
        houseEntity.setName(expectedName);

        HouseDto actualUpdateHouse = houseConnector.updateHouseById(houseEntity);

        SoftAssertions.assertSoftly(
                softAssertion -> {
                    softAssertion.assertThat(actualUpdateHouse.getName())
                            .as("Check correct name")
                            .isEqualTo(expectedName);
                }
        );
    }

    @Test(priority = 8)
    public void apiDeleteHouseTest() {
        StatusDto statusDeleteHouse = houseConnector.deleteHouseById(houseEntity);

        assertThat(statusDeleteHouse.getStatus())
                .as("Check Delete Status")
                .isEqualTo(1);
    }

    @Test(priority = 9)
    public void apiNotExistDeleteHouseTest() {
        List<HouseDto> houseList = houseConnector.getHouseList();

        List<Integer> houseIds = houseList.stream().map(HouseDto::getId).toList();

        assertThat(houseIds)
                .as("Check Not Available Delete House")
                .doesNotContain(houseEntity.getId());
    }
}
