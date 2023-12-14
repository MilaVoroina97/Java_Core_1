package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopAdder;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopCreator;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopManager;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShopAdder extends AbstractShopAdder {

    public ShopAdder(AbstractShopCreator shopCreator, AbstractShopManager shopManager){

        this.shopCreator = shopCreator;
        this.shopManager = shopManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void addShopItem(String type) throws IOException {

        switch (type){
            case ("Product") -> this.shopManager.addProduct(shopCreator.createProduct(),getIndex(type));
            case ("Customer") -> this.shopManager.addCustomer(shopCreator.createCustomer(),getIndex(type));
        }

    }

    @Override
    public Customer findCustomer(String findCustomerSecondName) throws NoExistCustomerException {


        for(Customer c : this.shopManager.getAllCustomers()){
            if(c.getSecondName().equals(findCustomerSecondName)) return c;

        }
        return null;
    }

    @Override
    public Product findProduct(String findProductName) throws NoExistProductException {
        for(Product p : this.shopManager.getAllProducts()){
            if(p.getName().equals(findProductName)) return p;
        }
        return null;
    }


    private int getIndex(String type) throws IOException{
        System.out.printf("Enter %s place in shop.\n", type);
        boolean isTrue = false;
        int result = 0;
        while (!isTrue){
            try {
                result = Integer.parseInt(this.reader.readLine());
                isTrue = true;
            }catch (IOException ex){
                System.out.println("Input error");
            }
        }
        return result;
    }


}
