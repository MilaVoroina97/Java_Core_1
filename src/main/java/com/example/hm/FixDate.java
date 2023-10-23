package com.example.hm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FixDate {

    private LocalDate localDate;

    public FixDate(){

        this.localDate = LocalDate.now();
    }

    public String getCurentDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return localDate.format(formatter);

    }
}
