package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.CannotAddShopItemException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopManager;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public class ShopManager extends AbstractShopManager {

    private Customer[] customers;
    private Product[] products;

    public ShopManager(){
        this.customers = new Customer[15];
        this.products = new Product[15];
    }

    @Override
    public void addCustomer(Customer customer, int index) throws CannotAddShopItemException {

        boolean result = false;
        if(index < 0) index = 0;
        int size = (this.customers.length - 1 >= index) ? this.customers.length + 1 : index + 1;
        Customer[] tmp = new Customer[size];
        for(int i = 0; i < tmp.length; i++){
            if(i < index)
                tmp[i] = this.customers[i];
            else if(i == index){
                tmp[i] = customer;
                result = true;
            }else
                tmp[i] = this.customers[i - 1];
        }
        if(!result) throw new CannotAddShopItemException("Cannot add this customer");

        this.customers = tmp;
        System.out.println("Customer was successfully added");
    }

    @Override
    public Customer[] getAllCustomers() {
        return this.customers;
    }

    @Override
    public void addProduct(Product product, int index) throws CannotAddShopItemException {
        boolean result = false;
        if(index < 0) index = 0;
        int size = (this.products.length - 1 >= index) ? this.products.length + 1 : index + 1;
        Product[] tmp = new Product[size];
        for(int i = 0; i < tmp.length; i++){
            if(i < index)
                tmp[i] = this.products[i];
            else if(i == index){
                tmp[i] = product;
                result = true;
            }else
                tmp[i] = this.products[i - 1];
        }
        if(!result) throw new CannotAddShopItemException("Cannot add this customer");

        this.products = tmp;
        System.out.println("Product was successfully added");
    }

    @Override
    public Product[] getAllProducts() {
        return this.products;
    }
}
