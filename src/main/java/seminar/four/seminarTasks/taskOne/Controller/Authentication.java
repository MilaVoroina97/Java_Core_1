package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;

import java.io.IOException;

public interface Authentication {

    boolean validate(Validator validator) throws IOException, WrongPasswordException, WrongLoginException;
}
