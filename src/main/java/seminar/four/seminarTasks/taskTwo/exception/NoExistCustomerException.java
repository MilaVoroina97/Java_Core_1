package seminar.four.seminarTasks.taskTwo.exception;

public class NoExistCustomerException extends NoExistShopItemException{

    public NoExistCustomerException(String message){
        super(message);
    }
}
