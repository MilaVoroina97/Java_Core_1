package homework.four.task2;


/**
 * Исключение, выбрасываемое при неверном количестве товара.
 */
public class AmountException extends Exception{


    public AmountException(String message) {
        super(message);
    }
}
