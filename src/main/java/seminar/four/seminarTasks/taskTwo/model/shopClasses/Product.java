package seminar.four.seminarTasks.taskTwo.model.shopClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.ShopItem;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product extends ShopItem {

    private String name;
    private double price;

    public Product(String name, double price) {

        super(name);
        this.price = price;

    }
}
