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
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException ne) {
                System.out.println("Input is not a number, continue");
            }
        }
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
