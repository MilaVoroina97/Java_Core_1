package seminar.four.seminarTasks.taskTwo.model.abstractClasses;

public abstract class ShopItem {

    protected String name;

    public ShopItem(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
