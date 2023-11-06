package homework.four.task1;

public class WrongLoginException extends Exception{

    /* Конструктор по умолчанию
    * */

    public WrongLoginException() {
        super("Используются недопустимые для логина символы.");
    }

    /**
     * Конструктор с выводом сообщения ошибки.
     * @param message - сообщение ошибки
     */
    public WrongLoginException(String message) {
        super(message);
    }

}
