package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCostumerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShop;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Order;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public class Shop extends AbstractShop {
    @Override
    public Customer findCustomer(Customer[] customers, Customer customer) throws NoExistCostumerException {
        return null;
    }

    @Override
    public Product findProduct(Product[] products, Product product) throws NoExistProductException {
        return null;
    }

    @Override
    public Order makePurchase() {
        return null;
    }
}
