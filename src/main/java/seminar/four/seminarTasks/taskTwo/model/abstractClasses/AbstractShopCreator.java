package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.creators.CustomerCreator;
import seminar.four.seminarTasks.taskTwo.interfaces.creators.ProductCreator;

public abstract class AbstractShopCreator implements CustomerCreator, ProductCreator {

    protected AbstractShopParams shopParams;
}
