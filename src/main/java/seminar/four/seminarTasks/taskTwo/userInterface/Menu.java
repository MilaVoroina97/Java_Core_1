package seminar.four.seminarTasks.taskTwo.userInterface;

import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.infrastructure.*;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShop;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {

    private final AbstractShop shop;

    private  final AbstractShopAdder shopAdder;
    private final View view;

    public Menu() {
        this.shopAdder = new ShopAdder(new ShopCreator(new ShopParams(null)),new ShopManager());
        this.view = new ConsoleView();
        this.shop = new Shop(new ShopAdder(new ShopCreator(new ShopParams(null)),new ShopManager()));
    }

    private int menu() throws IOException {
        System.out.println("Choose operation:");
        System.out.println("Add a new shop item to the shop, press 1");
        System.out.println("Find customer in the shop, press 2");
        System.out.println("Find product in the shop, press 3");
        System.out.println("Make an order, press 4");
        System.out.println("Exit from the shop, press 0");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            return Integer.parseInt(reader.readLine());
        }
    }

    private void addShopItemMenu() throws IOException{
        System.out.println("For adding a customer press 1");
        System.out.println("For adding a product press 2");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            switch (Integer.parseInt(reader.readLine())){
                case (1) -> shopAdder.addShopItem("Customer");
                case (2) -> shopAdder.addShopItem("Product");
            }
        }

    }

    private void findShopItemMenu() throws  IOException{
        System.out.println("For finding a customer press 1");
        System.out.println("For finding a product press 2");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            switch (Integer.parseInt(reader.readLine())){
                case (1) -> shopAdder.findCustomer(view.getCustomerToFind());
                case (2) -> shopAdder.findProduct(view.getProductToFind());
            }
        } catch (NoExistCustomerException | NoExistProductException e) {
            System.out.println(e.getMessage());
        }
    }

    private void makePurchaseMenu() throws IOException{

    }

}
