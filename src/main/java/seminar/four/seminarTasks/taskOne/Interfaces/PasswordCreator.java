package seminar.four.seminarTasks.taskOne.Interfaces;

import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.Password;

import java.io.IOException;

public interface PasswordCreator {

    public Password createPassword() throws IOException;
}
