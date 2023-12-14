package seminar.four.seminarTasks.taskTwo.interfaces.shopManager;

import seminar.four.seminarTasks.taskTwo.exception.CannotAddShopItemException;
import seminar.four.seminarTasks.taskTwo.model.abstractClasses.ShopItem;
import seminar.four.seminarTasks.taskTwo.model.shopClasses.Product;

public interface AddProduct {

    public boolean addProduct(Product product, int index) throws CannotAddShopItemException;

    public Product[] getAllProducts();
}
