package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;
import seminar.four.seminarTasks.taskOne.NewController.Creator;
import seminar.four.seminarTasks.taskOne.Viewer.ParamCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Viewer {

    private static final Validator validator = new Validator(new Creator(new ParamCreator(null)));
    private static final Authentication passwordAuthentication = new PasswordValidator();
    private static final Authentication loginAuthentication = new LoginValidator();

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private  static boolean working = true;

    private static int menu() throws IOException{


        System.out.println("Choose operation:");
        System.out.println("Enter login ->  press 1");
        System.out.println("Enter password -> press 2");
        System.out.println("To exit -> press 0");
        return Integer.parseInt(reader.readLine());

    }

    public static void start() throws IOException {

        try {
            while (working){
                int operation = menu();
                switch (operation){
                    case (1) -> loginAuthentication.validate(validator);
                    case (2) -> passwordAuthentication.validate(validator);
                    case (0) -> working = false;
                }
            }
        }catch (IOException | WrongLoginException| WrongPasswordException ex){
            System.out.println(ex.getMessage());
        }

    }
}
