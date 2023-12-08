package seminar.four.seminarTasks.taskOne.Model.AbstractClasses;

import seminar.four.seminarTasks.taskOne.Interfaces.PrintInfo;

public class AbstractLogin implements PrintInfo {

    protected String login;
    public AbstractLogin(String login){
        this.login = login;
    }

    public void setLogin(String newLogin){
        this.login = newLogin;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void printAllInfo() {
        System.out.println("Your login is" + this.login);
    }
}
