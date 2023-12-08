package seminar.four.seminarTasks.taskOne.Controller;

import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractCreator;
import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractParams;
import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.ConfirmPassword;
import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.Login;
import seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses.Password;

import java.io.IOException;

public class Creator extends AbstractCreator {

    public Creator(AbstractParams params){
        this.abstractParams = params;
    }
    @Override
    public Login createLogin() throws IOException {

        return new Login(abstractParams.getLogin("login"));
    }

    @Override
    public Password createPassword() throws IOException {
        return new Password(abstractParams.getPassword("password"));
    }

    @Override
    public ConfirmPassword createConfirmPassword() throws IOException{
        return new ConfirmPassword(abstractParams.getPassword("confirm password"));
    }


}
