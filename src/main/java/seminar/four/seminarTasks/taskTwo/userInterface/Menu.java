package seminar.four.seminarTasks.taskTwo.userInterface;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.infrastructure.*;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShop;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Menu {

    private final AbstractShop shop;

    private  final AbstractShopAdder shopAdder;
    private final View view;

    private final BufferedReader reader;



    public Menu() {
        this.shopAdder = new ShopAdder(new ShopCreator(new ShopParams(null)),new ShopManager());
        this.view = new ConsoleView();
        this.shop = new Shop(new ShopAdder(new ShopCreator(new ShopParams(null)),new ShopManager()));
        this.reader =  new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException, NegativeAmountException, NoExistProductException, NoExistCustomerException {
        boolean working = true;
        while (working){
            int operation = menu();
            switch (operation){
                case (1) -> addShopItemMenu();
                case (2) -> findShopItemMenu();
                case (3) -> makePurchaseMenu();
                case (0) -> working = false;
                default -> System.out.println("There is not such option, please,try again");
            }

        }
    }

    private int menu() throws IOException {
        System.out.println("Choose operation:");
        System.out.println("Add a new shop item to the shop, press 1");
        System.out.println("Find shop item in the shop, press 2");
        System.out.println("Make an order, press 3");
        System.out.println("Exit from the shop, press 0");
        return Integer.parseInt(reader.readLine());

    }

//    private void addShopItemMenu() throws IOException{
//        System.out.println("For adding a customer press 1");
//        System.out.println("For adding a product press 2");
//        System.out.println("Go back to menu, press 9");
//        boolean isWorking = true;
//        try (Scanner in = new Scanner(System.in)){
//            while (isWorking){
//                int input = Integer.parseInt(in.nextLine());
//                switch (input){
//                    case (1) -> shopAdder.addShopItem("Customer");
//                    case (2) -> shopAdder.addShopItem("Product");
//                    case (9) -> isWorking = false;
//                    default -> System.out.println("There is not such option, please,try again");
//                }
//            }
//        }
//
//    }

    private void addShopItemMenu() throws IOException{
        System.out.println("For adding a customer press 1");
        System.out.println("For adding a product press 2");
        switch (Integer.parseInt(reader.readLine())){
            case (1) -> shopAdder.addShopItem("Customer");
            case (2) -> shopAdder.addShopItem("Product");
            default -> System.out.println("There is not such option, please,try again");
        }
    }



//    private void findShopItemMenu() throws  IOException{
//        System.out.println("For finding a customer press 1");
//        System.out.println("For finding a product press 2");
//        try (Scanner in = new Scanner(System.in)){
//            while (in.hasNextLine()){
//                int input = Integer.parseInt(in.nextLine());
//                switch (input){
//                    case (1) -> shopAdder.findCustomer(view.getCustomerToFind());
//                    case (2) -> shopAdder.findProduct(view.getProductToFind());
//                    default -> System.out.println("There is not such option, please,try again");
//                }
//            }
//        } catch (NoExistProductException | NoExistCustomerException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
private void findShopItemMenu() throws IOException, NoExistCustomerException, NoExistProductException {

        System.out.println("For finding a customer press 1");
        System.out.println("For finding a product press 2");

        switch (Integer.parseInt(reader.readLine())){
            case (1) -> System.out.println(shopAdder.findCustomer(view.getCustomerToFind()));
            case (2) -> System.out.println(shopAdder.findProduct(view.getProductToFind()));
            default -> System.out.println("There is not such option, please,try again");
        }



    }

    private void makePurchaseMenu() throws IOException, NegativeAmountException, NoExistProductException, NoExistCustomerException {

        System.out.println("Your order is: " + shop.makePurchase(view.getCustomerToFind(), view.getProductToFind()));
    }

}
