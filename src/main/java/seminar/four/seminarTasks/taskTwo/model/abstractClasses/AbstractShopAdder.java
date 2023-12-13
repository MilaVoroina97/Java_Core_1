package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.shopAdder.AddCostumerManager;
import seminar.four.seminarTasks.taskTwo.interfaces.shopAdder.AddProductManager;

import java.io.BufferedReader;

public abstract class AbstractShopAdder implements AddCostumerManager, AddProductManager {

    protected AbstractShopManager shopManager;
    protected AbstractShopCreator shopCreator;
    protected BufferedReader reader;

}
