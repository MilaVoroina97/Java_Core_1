package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.shop.FindCustomer;
import seminar.four.seminarTasks.taskTwo.interfaces.shop.FindProduct;
import seminar.four.seminarTasks.taskTwo.interfaces.shop.MakePurchase;

public abstract class AbstractShop implements MakePurchase, FindProduct, FindCustomer {

    protected AbstractShopManager shopManager;
}
