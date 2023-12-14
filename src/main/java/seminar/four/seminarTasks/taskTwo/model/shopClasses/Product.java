package seminar.four.seminarTasks.taskTwo.model.shopClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.ShopItem;



public class Product{

    private String name;
    private double price;

    public Product(String name, double price) {

        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product {" +
                "name = '" + name + '\'' +
                ", price = " +price +
                '}';
    }
}
