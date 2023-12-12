package seminar.four.seminarTasks.taskTwo.model.shopClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {

        this.name = name;
        this.price = price;

    }
}
