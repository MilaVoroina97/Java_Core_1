package seminar.four.seminarTasks.taskTwo;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistShopItemException;
import seminar.four.seminarTasks.taskTwo.userInterface.NewMenu;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws NegativeAmountException, NoExistShopItemException, IOException {

        NewMenu menu = new NewMenu();
        menu.start();
    }
}
