package homework.four.task2;

/**
 * Исключение, выбрасываемое при неверном покупателе.
 */
public class CustomerException extends Exception{

    public CustomerException(String message) {
        super(message);
    }
}
