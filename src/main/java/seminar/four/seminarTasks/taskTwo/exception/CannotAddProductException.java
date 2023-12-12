package seminar.four.seminarTasks.taskTwo.exception;

public class CannotAddProductException extends RuntimeException{

    public CannotAddProductException(String message){
        super(message);
    }
}
