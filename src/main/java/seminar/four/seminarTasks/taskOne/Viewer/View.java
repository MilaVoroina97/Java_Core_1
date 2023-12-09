package seminar.four.seminarTasks.taskOne.Viewer;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;
import seminar.four.seminarTasks.taskOne.Controller.Creator;
import seminar.four.seminarTasks.taskOne.NewController.AbstractLoginValidator;
import seminar.four.seminarTasks.taskOne.NewController.AbstractPasswordValidator;
import seminar.four.seminarTasks.taskOne.NewController.LoginValidator;
import seminar.four.seminarTasks.taskOne.NewController.PasswordValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    private  static AbstractPasswordValidator passwordValidator = new PasswordValidator(new Creator(new ParamCreator(null)));
    private static AbstractLoginValidator loginValidator = new LoginValidator(new Creator(new ParamCreator(null)));
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private  static boolean working = true;


    public static void start() throws IOException {

        try {
            while (working){
                int operation = menu();
                switch (operation){
                    case (1) -> checkLogins();
                    case (2) -> checkPasswords();
                    case (0) -> working = false;
                }
            }
        }catch (IOException | WrongLoginException| WrongPasswordException ex){
            System.out.println(ex.getMessage());
        }

    }

    private  static void checkPasswords() throws IOException, WrongPasswordException {

        try {
            boolean result = passwordValidator.checkPassword();
            System.out.println(result);
            if(result) System.out.println("Пароль введен верно");
        }catch (IOException | WrongPasswordException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void checkLogins() throws IOException, WrongLoginException {

        try {
            boolean result = loginValidator.checkLogin();
            System.out.println(result);
            if(result) System.out.println("Логин введен верно");
        }catch (IOException | WrongLoginException ex){
            System.out.println(ex.getMessage());
        }
    }


    private static int menu() throws IOException{


        System.out.println("Choose operation:");
        System.out.println("Enter login ->  press 1");
        System.out.println("Enter password -> press 2");
        System.out.println("To exit -> press 0");
        return Integer.parseInt(reader.readLine());

    }

}
