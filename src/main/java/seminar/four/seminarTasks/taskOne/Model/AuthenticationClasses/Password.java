package seminar.four.seminarTasks.taskOne.Model.AuthenticationClasses;

import seminar.four.seminarTasks.taskOne.Model.AbstractClasses.AbstractPassword;

public class Password extends AbstractPassword {
    public Password(String password) {
        super(password);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof  ConfirmPassword)) return false;
        AbstractPassword confirmPassword = (ConfirmPassword) obj;
        return password.equals(confirmPassword.getPassword());
    }
}
