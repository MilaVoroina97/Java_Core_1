package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;
import lombok.AllArgsConstructor;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractCreator;

import java.io.IOException;
public class Validator implements IValidator{

    protected AbstractCreator creator;

    public Validator(AbstractCreator creator) {
        this.creator = creator;
    }

    @Override
    public boolean checkLogin() throws WrongLoginException, IOException {
        return false;
    }

    @Override
    public boolean checkPassword() throws WrongPasswordException, IOException {
        return false;
    }
}
