package seminar.four.seminarTasks.taskTwo.interfaces.shopManager;

import seminar.four.seminarTasks.taskTwo.exception.CannotAddCustomerException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;

public interface AddCustormer {

    public boolean addCustomer(Customer customer,int index) throws CannotAddCustomerException;
}
