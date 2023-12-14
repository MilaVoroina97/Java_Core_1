package seminar.four.seminarTasks.taskTwo.model.shopClasses;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Order {

    private Customer customer;
    private Product product;
    private int amount;

    public Order(Customer customer, Product product, int amount){
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order {" +
                "customer = '" + customer.toString() + '\'' +
                ", product = " +product.toString() +
                ", amount = '" + amount + '\'' +
                '}';
    }

}
