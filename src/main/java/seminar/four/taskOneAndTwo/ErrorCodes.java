package seminar.four.taskOneAndTwo;

public enum ErrorCodes{

    FIRST_ERROR(1),
    SECOND_ERROR(2);
    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
