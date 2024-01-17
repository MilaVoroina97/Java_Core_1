package seminar.five.lection.chainPattern;

public class ValHandler extends StatementHandler{
    @Override
    boolean isValid(String statement) {

        if(statement.contains("val"))
            return false;
        if(next != null)
            return next.isValid(statement);
        return true;
    }
}
