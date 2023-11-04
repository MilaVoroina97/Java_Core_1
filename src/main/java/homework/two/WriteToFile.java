package homework.two;

import com.example.hm.FixDate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class WriteToFile {

    protected Scanner sc = new Scanner(System.in);
    protected String fileName = "testFile.txt";
    protected FixDate fixDate;

    public WriteToFile() {

        this.fixDate = new FixDate();
    }
    public void makeNewNote(){

      System.out.print("\033[H\033[J");


      try(Scanner scanner = new Scanner(System.in)) {
          boolean flag = true;
          while (flag) {

              System.out.println("\n1 - Make a new note \n0 - Exit");
              if(scanner.hasNextLine()){
                  String userChoice = scanner.nextLine();
                  switch (userChoice) {
                      case "1":

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
                          }
                          break;
                      case "0":
                          flag = false;
                          break;
                      default:
                          System.out.println("There is not such available option.");
                          break;

                  }
              }else{
                  sc.close();
                  break;

              }
          }
      }

    }

}
