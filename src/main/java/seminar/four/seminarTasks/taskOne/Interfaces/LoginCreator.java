package seminar.four.seminarTasks.taskOne.Interfaces;

import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.Login;

import java.io.IOException;

public interface LoginCreator {

    public Login createLogin() throws IOException;
}
