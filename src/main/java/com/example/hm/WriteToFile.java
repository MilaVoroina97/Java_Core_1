package com.example.hm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class WriteToFile {

    protected Scanner in;
    protected String fileName;

    protected FixDate fixDate;

    public WriteToFile() {

        this.in = new Scanner(System.in);
        this.fileName = "testFile.txt";
        this.fixDate = new FixDate();
    }
    public void makeNewNote(){

      System.out.print("\033[H\033[J");

            try(Scanner scanner = new Scanner(System.in)) {
                boolean flag = true;
                while (flag) {

                    System.out.println(
                            "\n1 - Записать заметку в файл\n0 - Выход");
                    String userChoice = scanner.nextLine();
                    switch (userChoice) {
                        case "1":

                            System.out.println("Введите Вашу заметку: ");
                            String userInput = in.nextLine();
                            try {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                                writer.append("\nДозапись в файл: ");
                                writer.append(fixDate.getCurrentDate());
                                writer.append("  ->  ");
                                writer.append(userInput);
                                writer.close();
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
