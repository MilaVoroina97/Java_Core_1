package seminar.three.lection.taskTwo.Viewer;

import seminar.three.lection.taskTwo.Model.Animal;

import java.util.Scanner;

public class ConsoleView implements View<Animal>{

    public Scanner scanner;

    public ConsoleView(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public double getUserInput() throws NumberFormatException {
        while (true){
            System.out.println("Enter a double number.");
            if(scanner.hasNextDouble()){
                try{
                    return Double.parseDouble(scanner.nextLine());

                }catch (NumberFormatException ne){
                    System.out.println("Input is not a number, continue");
                }
            }else{
                System.out.println("You need to enter only integer number");
            }

        }
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
