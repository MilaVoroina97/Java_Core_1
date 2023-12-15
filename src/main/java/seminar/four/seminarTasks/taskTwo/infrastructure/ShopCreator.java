package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopCreator;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopParams;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.IOException;

public class ShopCreator extends AbstractShopCreator {

    public ShopCreator(AbstractShopParams shopParams){
        this.shopParams = shopParams;
    }
    @Override
    public Customer createCustomer() throws IOException {
        return new Customer(this.shopParams.getName("name"),
                this.shopParams.getLastName("lastname"),
                this.shopParams.getPhoneNumber("phone number"));
    }

    @Override
    public Product createProduct() throws IOException {
        return new Product(this.shopParams.getName("product"),this.shopParams.getPrice("product"));
    }


    @Override
    public int getAmount(String type) throws IOException, NegativeAmountException {
        return this.shopParams.getAmount(type);
    }
}
