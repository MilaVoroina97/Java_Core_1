package com.example.hm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFileTwo {

    protected Scanner sc = new Scanner(System.in);
    protected String fileName = "testFile.txt";
    protected FixDate fixDate;

    public WriteToFileTwo() {

        this.fixDate = new FixDate();
    }

    public void makeNote(){

        System.out.println("Make your note, if you want to exit, please, press 0. ");
        while(sc.hasNextLine()) {

            System.out.println("Write your new note: ");
            String userInput = sc.nextLine();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.append("\nAdd to the file: ");
                writer.append(fixDate.getCurrentDate());
                writer.append("  ->  ");
                writer.append(userInput);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }if(userInput.equals("0")) break;

        }
        sc.close();
    }

}

