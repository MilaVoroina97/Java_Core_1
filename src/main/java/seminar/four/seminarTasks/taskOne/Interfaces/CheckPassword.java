package seminar.four.seminarTasks.taskOne.Interfaces;

import homework.four.task1.WrongPasswordException;

import java.io.IOException;

public interface CheckPassword {

    public boolean checkPassword() throws WrongPasswordException, IOException;
}
