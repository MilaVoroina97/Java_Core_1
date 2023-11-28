package seminar.three.lection.taskTwo.Viewer;

import seminar.three.lection.taskTwo.Model.Animal;

import java.util.InputMismatchException;
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
                return scanner.nextDouble();
            } catch (InputMismatchException ne) {
                /*InputMismatchException – if the next token does not match the Float regular expression, or is out of range
                NoSuchElementException – if the input is exhausted
                IllegalStateException – if this scanner is closed*/
                System.out.println("Input is not a integer, continue");
                scanner.next();
            }
        }
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
