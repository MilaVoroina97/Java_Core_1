package homework.four.task1;

public class WrongPasswordException extends Exception{

    /* Конструктор по умолчанию
    * */
    public WrongPasswordException() {
        super("Используются недопустимые для пароля символы.");
    }

    /**
     * Конструктор с выводом сообщения ошибки.
     * @param message - сообщение ошибки.
     */
    public WrongPasswordException(String message) {
        super(message);
    }
}
