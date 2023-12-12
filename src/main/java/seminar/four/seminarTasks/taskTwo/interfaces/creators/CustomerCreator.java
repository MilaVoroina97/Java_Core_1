package seminar.four.seminarTasks.taskTwo.interfaces.creators;

import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;

import java.io.IOException;

public interface CustomerCreator {

    public Customer createCustomer() throws IOException;
}
