package seminar.four.seminarTasks.taskTwo.interfaces.shop;

import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public interface FindProduct {

    public Product findProduct(Product[] products, Product product) throws NoExistProductException;
}
