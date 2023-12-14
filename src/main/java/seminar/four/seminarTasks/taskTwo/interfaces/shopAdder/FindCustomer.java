package seminar.four.seminarTasks.taskTwo.interfaces.shopAdder;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;

public interface FindCustomer {

    public Customer findCustomer(String findCustomerSecondName) throws NoExistCustomerException;
}
