package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCostumerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShop;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopCreator;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopManager;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Order;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Shop extends AbstractShop {


    public Shop(AbstractShopManager shopManager, AbstractShopCreator creator){
        this.shopManager = shopManager;
        this.shopCreator = creator;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public Customer findCustomer(Customer customer) throws NoExistCostumerException {


        return null;
    }

    @Override
    public Product findProduct(Product product) throws NoExistProductException {
        return null;
    }

    @Override
    public Order makePurchase() {
        return null;
    }
}
