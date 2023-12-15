package seminar.four.seminarTasks.taskTwo.interfaces.shop;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistShopItemException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Order;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.IOException;

public interface MakePurchase {

    public Order makePurchase(String findCustomerSecondName, String findProductName) throws NoExistShopItemException, NegativeAmountException, IOException;

}
