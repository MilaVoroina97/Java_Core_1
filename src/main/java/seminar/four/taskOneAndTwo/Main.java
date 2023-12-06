package seminar.four.taskOneAndTwo;

/**
 *  1. Напишите два наследника класса Exception: ошибка преобразования строки и
 * ошибка преобразования столбца
 * 2. Разработайте исключения-наследники так, чтобы они информировали
 * пользователя в формате ожидание/реальность
 */
public class Main {
    public static void main(String[] args) throws Exception {

        try {
            validateColumn(-5);
        }catch (ColumnConvertionErrorException exception){
            System.out.println("It is expected to  create 5 columns, but reality is no any columns were created " +
                    "due to negative columns number");
        }

        try {
            validateString(null);
        }catch (StringConvertionErrorException ex){
            System.out.println("It is expected to create String, but reality is that no any String was created" +
                    "as input was null");
        }

    }
    public static Exception getException(int errorCode){


            return switch (errorCode){
                case 1 -> new StringConvertionErrorException("Наше крутое исключение! Мы получили ошибку: " +
                                ErrorCodes.FIRST_ERROR.getCode(), new Throwable(), ErrorCodes.FIRST_ERROR);
                
                case 2 -> new ColumnConvertionErrorException("Наше крутое исключение! Мы получили ошибку: " +
                            ErrorCodes.SECOND_ERROR.getCode(), new Throwable(), ErrorCodes.SECOND_ERROR);


                default -> throw new IllegalStateException("Unexpected value: " + errorCode);
            };

    }

    public static void validateString(String inputString) throws StringConvertionErrorException {
        if(inputString == null || inputString.isEmpty())
            throw new StringConvertionErrorException("Input cannot be null or empty");
    }

    public static void validateColumn(int columnNumber) throws ColumnConvertionErrorException {
        if(columnNumber < 0)
            throw new ColumnConvertionErrorException("Значение должно быть больше или равно нулю");
    }


}
