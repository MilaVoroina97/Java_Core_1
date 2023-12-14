package seminar.four.seminarTasks.taskTwo.infrastructure;


import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShop;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Order;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  ЭТОТ КЛАСС БОЛЕЕ НЕ ИСПОЛЬЗУЕТСЯ
 */

public class Shop extends AbstractShop {


    public Shop(ShopAdder shopAdder){
        this.shopAdder = shopAdder;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public Order makePurchase(String findCustomerSecondName, String findProductName) throws NoExistCustomerException, NoExistProductException, IOException, NegativeAmountException {

        Customer customer = this.shopAdder.findCustomer(findCustomerSecondName);
        if(customer == null)
            throw new NoExistCustomerException("There is not such customer in this shop");
        Product product = this.shopAdder.findProduct(findProductName);
        if(product == null)
            throw new NoExistProductException("There is not such product in this shop");
        int amount = getAmount();
        return new Order(customer,product,amount);
    }


    private int getAmount() throws IOException, NegativeAmountException {

        int result = 0;
        System.out.println("Enter the necessary amount: ");
        try {
            result = Integer.parseInt(reader.readLine());
            if(result < 0)
                throw new NegativeAmountException("(\"The amount must be more than zero");
        }catch (IOException ex){
            System.out.println("Input error");
        }

        return result;
    }
}
