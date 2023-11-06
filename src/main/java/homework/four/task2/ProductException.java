package homework.four.task2;

/**
 * Исключение, выбрасываемое при неверном товаре.
 */
public class ProductException extends Exception{

    public ProductException(String message) {
        super(message);
    }
}
