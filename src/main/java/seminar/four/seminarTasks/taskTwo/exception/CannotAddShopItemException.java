package seminar.four.seminarTasks.taskTwo.exception;

public class CannotAddShopItemException extends  RuntimeException{

    public CannotAddShopItemException(String message){
        super(message);
    }
}
