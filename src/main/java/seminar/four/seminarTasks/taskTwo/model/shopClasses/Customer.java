package seminar.four.seminarTasks.taskTwo.model.shopClasses;

import seminar.four.seminarTasks.taskTwo.model.abstractClasses.ShopItem;

public class Customer {

    private String name;
    private String secondName;
    private String phoneNumber;

    public Customer(String firstName, String secondName, String phoneNumber) {
        this.name = firstName;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "name = '" + name + '\'' +
                ", second Name = " +secondName +
                ", phone number = '" + phoneNumber + '\'' +
                '}';
    }
}
