package seminar.four.seminarTasks.taskTwo.userInterface;

import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements View {

    private BufferedReader reader;

    public ConsoleView(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public String getCustomerToFind() throws IOException {

        System.out.println("Please, enter second name of client, which you want to find: ");
        return reader.readLine();
    }

    @Override
    public String getProductToFind() throws IOException {
        System.out.println("Please, enter name of product, which you want to find: ");
        return reader.readLine();
    }

    @Override
    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
