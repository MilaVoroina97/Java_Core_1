package seminar.four.seminarTasks.taskTwo.interfaces.params;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;

import java.io.IOException;

public interface GetAmount {

    public int getAmount(String type) throws IOException, NegativeAmountException;
}
