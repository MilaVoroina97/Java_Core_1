package seminar.five.lection.chainPattern;

public class LengthHandler extends StatementHandler{
    @Override
    boolean isValid(String statement) {

        if(statement.length() > 50)
            return false;
        if(next != null)
            return next.isValid(statement);
        return true;
    }
}
