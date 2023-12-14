package seminar.four.seminarTasks.taskTwo;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.userInterface.Menu;
import seminar.four.seminarTasks.taskTwo.userInterface.NewMenu;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws NegativeAmountException, NoExistProductException, NoExistCustomerException, IOException {

        NewMenu menu = new NewMenu();
        menu.start();
    }
}
