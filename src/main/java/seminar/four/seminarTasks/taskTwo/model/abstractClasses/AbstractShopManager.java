package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.shopManager.AddCustormer;
import seminar.four.seminarTasks.taskTwo.interfaces.shopManager.AddProduct;

import java.io.BufferedReader;

public abstract class AbstractShopManager implements AddCustormer, AddProduct {

    protected AbstractShopCreator creator;
    protected BufferedReader reader;

}
