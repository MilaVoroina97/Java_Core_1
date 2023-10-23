package com.example.hm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {

    private Scanner in = new Scanner(System.in);
    private String fileName = "testFile.txt";

    private FixDate fixDate;

    public WriteToFile() {

        this.fixDate = new FixDate();
    }
    public void writeToFile(){

        System.out.print("\033[H\033[J");

        try(Scanner scanner = new Scanner(System.in)){
            boolean flag = true;
            while(flag){

                System.out.println(
                        "\n1 - Записать заметку в файл\n0 - Выход");
                String userChoice = scanner.nextLine();
                switch (userChoice){
                    case "1":

                        System.out.println("Введите Вашу заметку: ");
                        String userInput = in.nextLine();
                        try {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                            writer.append("\nДозапись в файл:");
                            writer.append(fixDate.getCurentDate());
                            writer.append(userInput);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("такого варианта нет");
                        break;

                }
            }


        }
    }

}
