package seminar.four.seminarTasks.taskTwo.userInterface;


import seminar.four.seminarTasks.taskTwo.model.shopClasses.Customer;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.IOException;

public interface View {

    public String getCustomerToFind() throws IOException;
    public String getProductToFind() throws IOException;
    public void showMessage(String msg);
}
