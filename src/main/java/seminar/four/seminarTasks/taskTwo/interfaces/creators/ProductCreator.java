package seminar.four.seminarTasks.taskTwo.interfaces.creators;

import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

import java.io.IOException;

public interface ProductCreator {

    public Product createProduct() throws IOException;
}
