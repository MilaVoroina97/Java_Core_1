package seminar.four.seminarTasks.taskTwo.interfaces.shopManager;

import seminar.four.seminarTasks.taskTwo.exception.CannotAddShopItemException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;

public interface AddCustomer {

    public void addCustomer(Customer customer, int index) throws CannotAddShopItemException;

    public Customer[] getAllCustomers();
}
