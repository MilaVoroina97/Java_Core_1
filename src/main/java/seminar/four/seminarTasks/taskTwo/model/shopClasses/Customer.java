package seminar.four.seminarTasks.taskTwo.model.shopClasses;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.ShopItem;

@Setter
@Getter
@ToString
public class Customer extends ShopItem {

    private String secondName;
    private String phoneNumber;

    public Customer(String firstName, String secondName, String phoneNumber) {
        super(firstName);
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
