package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongPasswordException;

import java.io.IOException;

public class PasswordValidator implements Authentication{
    @Override
    public boolean validate(Validator validator) throws IOException, WrongPasswordException {
        return validator.checkPassword();
    }
}
