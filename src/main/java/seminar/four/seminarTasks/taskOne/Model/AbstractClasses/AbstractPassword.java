package seminar.four.seminarTasks.taskOne.Model.AbstractClasses;

import seminar.four.seminarTasks.taskOne.Interfaces.PrintInfo;

public class AbstractPassword implements PrintInfo {

    protected String password;

    public AbstractPassword(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void printAllInfo() {
        System.out.println("Your password is: " + this.password);
    }
}
