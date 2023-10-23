package com.example.hm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FixDate {

    protected LocalDateTime localDate;

    public FixDate(){

        this.localDate = LocalDateTime.now();
    }

    public String getCurrentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return localDate.format(formatter);

    }
}
