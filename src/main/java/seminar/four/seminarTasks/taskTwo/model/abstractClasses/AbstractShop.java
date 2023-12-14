package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.shop.MakePurchase;

import java.io.BufferedReader;

public abstract class AbstractShop implements MakePurchase{

    protected AbstractShopAdder shopAdder;
    protected BufferedReader reader;
}
