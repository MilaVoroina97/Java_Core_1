package seminar.four.seminarTasks.taskOne.Interfaces;

import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.ConfirmPassword;

import java.io.IOException;

public interface ConfirmPasswordCreator {

    public ConfirmPassword createConfirmPassword() throws IOException;
}
