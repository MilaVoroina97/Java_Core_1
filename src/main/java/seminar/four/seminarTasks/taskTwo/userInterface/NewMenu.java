package seminar.four.seminarTasks.taskTwo.userInterface;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistCustomerException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.exception.NoExistShopItemException;
import seminar.four.seminarTasks.taskTwo.infrastructure.ShopAdder;
import seminar.four.seminarTasks.taskTwo.infrastructure.ShopCreator;
import seminar.four.seminarTasks.taskTwo.infrastructure.ShopManager;
import seminar.four.seminarTasks.taskTwo.infrastructure.ShopParams;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewMenu {

    private  final AbstractShopAdder shopAdder;
    private final View view;

    int userInput;

    public NewMenu() {
        this.shopAdder = new ShopAdder(new ShopCreator(new ShopParams(null)),new ShopManager());
        this.view = new ConsoleView();
        this.userInput = 0;
    }

    public void start() throws IOException, NegativeAmountException, NoExistShopItemException {
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
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (reader.readLine() != null){
                userInput = Integer.parseInt(reader.readLine());
            }
        }catch (IOException ex){

            System.out.println(ex.getMessage());
        }
        return userInput;
    }

    private void addShopItemMenu() throws IOException{
        System.out.println("For adding a customer press 1");
        System.out.println("For adding a product press 2");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (reader.readLine() != null){
                userInput = Integer.parseInt(reader.readLine());
            }
            switch (userInput){
                case (1) -> shopAdder.addShopItem("Customer");
                case (2) -> shopAdder.addShopItem("Product");
                default -> System.out.println("There is not such option, please,try again");
            }

        }catch (IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    private void findShopItemMenu() throws IOException, NoExistCustomerException, NoExistProductException {

        System.out.println("For finding a customer press 1");
        System.out.println("For finding a product press 2");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (reader.readLine() != null) {
                userInput = Integer.parseInt(reader.readLine());
                switch (userInput) {
                    case (1) -> System.out.println(shopAdder.findCustomer(view.getCustomerToFind()));
                    case (2) -> System.out.println(shopAdder.findProduct(view.getProductToFind()));
                    default -> System.out.println("There is not such option, please,try again");
                }
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private void makePurchaseMenu() throws IOException, NegativeAmountException, NoExistShopItemException {

        System.out.println("Your order is: " + shopAdder.makePurchase(view.getCustomerToFind(), view.getProductToFind()));
    }
}
