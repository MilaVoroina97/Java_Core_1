package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

import seminar.four.seminarTasks.taskTwo.interfaces.creators.CustomerCreator;
import seminar.four.seminarTasks.taskTwo.interfaces.creators.ProductCreator;
import seminar.four.seminarTasks.taskTwo.interfaces.params.GetAmount;

public abstract class AbstractShopCreator implements CustomerCreator, ProductCreator, GetAmount {

    protected AbstractShopParams shopParams;
}
