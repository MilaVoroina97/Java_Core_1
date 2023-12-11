package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;

import java.io.IOException;

public interface IValidator {

    public boolean checkLogin() throws WrongLoginException, IOException;
    public boolean checkPassword() throws WrongPasswordException, IOException;
}
