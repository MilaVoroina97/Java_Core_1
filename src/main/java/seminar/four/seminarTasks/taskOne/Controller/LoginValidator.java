package seminar.four.seminarTasks.taskOne.Controller;

import homework.four.task1.WrongLoginException;
import seminar.four.seminarTasks.taskOne.Interfaces.CheckLogin;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractCreator;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractLogin;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class LoginValidator extends Validator implements CheckLogin {

    public LoginValidator(AbstractCreator creator){
        this.abstractCreator = creator;
    }

    @Override
    public boolean checkLogin() throws WrongLoginException, IOException {

        AbstractLogin login = abstractCreator.createLogin();
        if(login.getLogin().length() >= 20)
            throw new WrongLoginException(" Превышение длины логина.");
        CharacterIterator iterator = new StringCharacterIterator(login.getLogin());
                while (iterator.current() != CharacterIterator.DONE)
        {
            if(iterator.current() < '0' | iterator.current() > '9' & iterator.current() < 'A' |
                    iterator.current() > 'Z' & iterator.current() < 'a' & iterator.current() != '_' | iterator.current() > 'z'){
                throw new WrongLoginException();
            }
            iterator.next();
        }
        return true;
    }
}
