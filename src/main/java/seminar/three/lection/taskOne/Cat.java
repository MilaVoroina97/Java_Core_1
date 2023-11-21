package seminar.three.lection.taskOne;

/**
 * Написать класс кота так, чтобы каждому объекту кота присваивался личный
 * порядковый целочисленный номер.
 */

public class Cat {

    private static int count;
    private final int numberCount;

    public Cat(){

        count++;
        this.numberCount = getCount();

    }

    private int getCount(){
        return count;
    }

    public int getNumberCreation(){
        return this.numberCount;
    }

}
