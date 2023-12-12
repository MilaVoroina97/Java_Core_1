package seminar.four.seminarTasks.taskTwo.interfaces.shop;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCostumerException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;

public interface FindCustomer {

    public Customer findCustomer(Customer[] customers, Customer customer) throws NoExistCostumerException;
}
