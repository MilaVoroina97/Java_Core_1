package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;

import java.io.IOException;

public class LoginValidator implements Authentication{
    @Override
    public boolean validate(Validator validator) throws IOException, WrongLoginException {
        return validator.checkLogin();
    }
}
