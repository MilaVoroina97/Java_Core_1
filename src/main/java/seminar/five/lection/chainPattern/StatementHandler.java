package seminar.five.lection.chainPattern;


/**
 *  A handler should have only one method that validates a statement. It may also have a method for
 *  setting the next handler in the chain
 */

public abstract class StatementHandler {

    protected StatementHandler next;

    public void setNext(StatementHandler next) {
        this.next = next;
    }

    abstract boolean isValid(String statement);
}
