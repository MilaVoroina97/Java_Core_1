package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.CannotAddCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.CannotAddProductException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopManager;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public class ShopManager extends AbstractShopManager {


    private Product[] products;
    private Customer[] customers;

    public ShopManager(){
        this.customers = new Customer[10];
        this.products = new Product[10];
    }

    @Override
    public boolean addCustomer(Customer customer, int index) throws CannotAddCustomerException {

        boolean result = false;
        if(index < 0) index = 0;
        int size = (this.customers.length - 1 >= index) ? this.customers.length + 1 : index + 1;
        Customer[] tmp = new Customer[size];
        for(int i = 0; i < tmp.length; i ++) {
            if (i < index)
                tmp[i] = this.customers[i];
            else if(i == index){

                tmp[i] = customer;
                result = true;
            }
            else
                tmp[i] = this.customers[i - 1];

            }

        this.customers = tmp;
        return result;
    }

    @Override
    public boolean addProduct(Product product, int index) throws CannotAddProductException {
        boolean result = false;
        if(index < 0) index = 0;
        int size = (this.products.length - 1 >= index) ? this.products.length + 1 : index + 1;
        Product[] tmp = new Product[size];
        for(int i = 0; i < tmp.length; i ++) {
            if (i < index)
                tmp[i] = this.products[i];
            else if(i == index){

                tmp[i] = product;
                result = true;
            }
            else
                tmp[i] = this.products[i - 1];

        }

        this.products = tmp;
        return result;
    }

    public boolean addProduct(Product product){
        return this.addProduct(product,0);
    }

    public boolean addCustomer(Customer customer){
        return this.addCustomer(customer,0);
    }
}
