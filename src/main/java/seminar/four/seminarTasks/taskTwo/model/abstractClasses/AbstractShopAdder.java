package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.shopAdder.AddShopItemManager;
import seminar.four.seminarTasks.taskTwo.interfaces.shopAdder.FindCustomer;
import seminar.four.seminarTasks.taskTwo.interfaces.shopAdder.FindProduct;

import java.io.BufferedReader;

public abstract class AbstractShopAdder implements AddShopItemManager, FindProduct, FindCustomer {

    protected AbstractShopManager shopManager;
    protected AbstractShopCreator shopCreator;

    protected BufferedReader reader;

}
