package seminar.four.seminarTasks.taskOne.NewController;

import homework.four.task1.WrongPasswordException;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractCreator;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractPassword;

import java.io.IOException;

public class PasswordValidator extends AbstractPasswordValidator{

    public PasswordValidator(AbstractCreator creator){
        this.abstractCreator = creator;
    }

    @Override
    public boolean checkPassword() throws WrongPasswordException, IOException {
        AbstractPassword password = abstractCreator.createPassword();
        AbstractPassword confirmPassword = abstractCreator.createConfirmPassword();
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("Пароли не совпадают.");
        if (password.getPassword().length() >= 20)
            throw new WrongPasswordException("Превышение длины логина.");
        char[] characters = password.getPassword().toCharArray();
        for (char ch : characters) {
            if (ch < '0' | ch > '9' & ch < 'A' |
                    ch > 'Z' & ch < 'a' & ch != '_' | ch > 'z') {
                throw new WrongPasswordException();
            }

        }
        return true;
    }
}
