package seminar.four.seminarTasks.taskTwo.infrastructure;

import seminar.four.seminarTasks.taskTwo.exception.NegativeAmountException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.AbstractShopParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopParams extends AbstractShopParams {

    private final BufferedReader reader;

    public ShopParams(BufferedReader reader){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public int getAmount(String type) throws IOException, NegativeAmountException {
        System.out.println("Enter the necessary amount: ");
        int result = Integer.parseInt(reader.readLine());
        if(result < 0)
            throw new NegativeAmountException("(\"The amount must be more than zero");
        return result;
    }

    @Override
    public String getLastName(String type) throws IOException {
        System.out.printf("Enter %s lastname.\n", type);
        return reader.readLine();

    }

    @Override
    public String getName(String type) throws IOException {
        System.out.printf("Enter %s  name.\n", type);
        return reader.readLine();
    }

    @Override
    public String getPhoneNumber(String type) throws IOException {
        System.out.printf("Enter %s phone number.\n", type);
        return reader.readLine();
    }

    @Override
    public double getPrice(String type) throws IOException {
        System.out.println("Enter the price: ");
        boolean isTrue = false;
        double price = 0;
        while (!isTrue){
            price = Double.parseDouble(reader.readLine());
            if(price > 0) isTrue = true;
            else
                System.out.println("Price should be more than zero");
        }

        return price;
    }
}
