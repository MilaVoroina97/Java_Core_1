package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import homework.four.task1.WrongPasswordException;
import seminar.four.seminarTasks.taskOne.Interfaces.CheckPassword;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractCreator;
import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.ConfirmPassword;
import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.Password;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class PasswordValidator extends Validator implements CheckPassword {

    public PasswordValidator(AbstractCreator creator) {

        this.abstractCreator = creator;

    }

    @Override
    public boolean checkPassword() throws WrongPasswordException, IOException {
        Password password = abstractCreator.createPassword();
        ConfirmPassword confirmPassword = abstractCreator.createConfirmPassword();
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
