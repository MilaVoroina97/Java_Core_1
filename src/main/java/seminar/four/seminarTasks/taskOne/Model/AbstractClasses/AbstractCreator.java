package seminar.four.seminarTasks.taskOne.Model.AbstractClasses;

import seminar.four.seminarTasks.taskOne.Interfaces.ConfirmPasswordCreator;
import seminar.four.seminarTasks.taskOne.Interfaces.LoginCreator;
import seminar.four.seminarTasks.taskOne.Interfaces.PasswordCreator;

public abstract class AbstractCreator implements LoginCreator, PasswordCreator, ConfirmPasswordCreator {

    protected AbstractParams abstractParams;
}
