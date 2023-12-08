package seminar.four.seminarTasks.taskOne.Interfaces;

import homework.four.task1.WrongLoginException;

import java.io.IOException;

public interface CheckLogin {

    public boolean checkLogin() throws WrongLoginException, IOException;
}
