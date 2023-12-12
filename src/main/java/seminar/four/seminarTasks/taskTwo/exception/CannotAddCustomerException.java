package seminar.four.seminarTasks.taskTwo.exception;

public class CannotAddCustomerException extends  RuntimeException{

    public CannotAddCustomerException(String message){
        super(message);
    }
}
