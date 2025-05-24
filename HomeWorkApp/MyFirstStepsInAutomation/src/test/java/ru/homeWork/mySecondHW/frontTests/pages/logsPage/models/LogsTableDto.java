package ru.homeWork.mySecondHW.frontTests.pages.logsPage.models;

import lombok.Builder;
import lombok.Data;
import ru.homeWork.mySecondHW.frontTests.tools.DateHelper;

import java.time.LocalDate;

@Builder
@Data
public class LogsTableDto {
    private String date;
    private String action;
    private String user;
    private String ip;

    public LocalDate getDate(){
        return DateHelper.parseDateTimeString(date);
    }


}


