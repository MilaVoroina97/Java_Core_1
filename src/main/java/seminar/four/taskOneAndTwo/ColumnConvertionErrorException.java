package seminar.four.taskOneAndTwo;

public class ColumnConvertionErrorException extends Exception{

    private Integer errorCode;
    public ColumnConvertionErrorException(Throwable cause) {
        super(cause);
    }
    public ColumnConvertionErrorException(String message){
        super(message);
    }

    public ColumnConvertionErrorException(String message,Throwable cause, ErrorCodes errorCodes){
        super(message,cause);
        this.errorCode = errorCodes.getCode();
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
