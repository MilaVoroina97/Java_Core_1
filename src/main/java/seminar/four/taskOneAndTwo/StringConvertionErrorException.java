package seminar.four.taskOneAndTwo;

/**
 *  Напишите два наследника класса Exception: ошибка преобразования строки и
 * ошибка преобразования столбца
 */

public class StringConvertionErrorException extends Exception{

    private Integer errorCode;

    public StringConvertionErrorException(String message){
        super(message);
    }
    public StringConvertionErrorException(Throwable cause){
        super(cause);
    }
    public StringConvertionErrorException(String message,Throwable cause,ErrorCodes errorCode){
        super(message,cause);
        this.errorCode = errorCode.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}
