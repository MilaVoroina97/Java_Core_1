package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.*;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopAdder;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopCreator;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopManager;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Order;
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
        try{
            switch (type){
                case ("Product") -> this.shopManager.addProduct(shopCreator.createProduct(),getIndex(type));
                case ("Customer") -> this.shopManager.addCustomer(shopCreator.createCustomer(),getIndex(type));
            }
        }catch (IOException | CannotAddShopItemException ex){
            System.out.println(ex.getMessage());
        }


    }

    @Override
    public Customer findCustomer(String findCustomerSecondName) throws NoExistCustomerException {


        for(Customer c : this.shopManager.getAllCustomers())
            if(c != null){
                if (c.getSecondName().equals(findCustomerSecondName)){
                    System.out.println("Find");
                    return c;
                }
            }

        return null;
    }

    @Override
    public Product findProduct(String findProductName) throws NoExistProductException {
        for(Product p : this.shopManager.getAllProducts()){
            if(p != null){
                if(p.getName().equals(findProductName)){
                    System.out.println("Find");
                    return p;
                }
            }
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


    @Override
    public Order makePurchase(String findCustomerSecondName, String findProductName) throws NoExistShopItemException, NegativeAmountException, IOException {
        Customer customer = findCustomer(findCustomerSecondName);
        if(customer == null)
            throw new NoExistCustomerException("There is not such customer in this shop");
        Product product = findProduct(findProductName);
        if(product == null)
            throw new NoExistProductException("There is not such product in this shop");
        int amount = 0;
        try{
            amount = this.shopCreator.getAmount("amount");
        }catch (NegativeAmountException ex){
            System.out.println(ex.getMessage());
        }
        return new Order(customer,product,amount);
    }

//    private int getAmount() throws IOException, NegativeAmountException {
//
//        int result = 0;
//        System.out.println("Enter the necessary amount: ");
//        try {
//            result = Integer.parseInt(reader.readLine());
//            if(result < 0)
//                throw new NegativeAmountException("(\"The amount must be more than zero");
//        }catch (IOException ex){
//            System.out.println("Input error");
//        }
//
//        return result;
//    }
}
