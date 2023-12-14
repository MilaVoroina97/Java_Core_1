package seminar.four.seminarTasks.taskTwo.interfaces.shopAdder;

import seminar.four.seminarTasks.taskTwo.exception.NoExistProductException;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public interface FindProduct {

    public Product findProduct(String findProductName) throws NoExistProductException;
}
