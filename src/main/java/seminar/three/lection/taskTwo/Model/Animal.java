package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {

    private final List<Double> maxRunLength;
    private final List<Double> maxSwimLength;
    private final List<Double> maxJumpLength;

    private final static List<String> actions;

    static {
        actions = new ArrayList<>(Arrays.asList(new String[]{"run","jump","swim"}));
    }

    public Animal(List<Double> maxRunLength, List<Double> maxSwimLength, List<Double> maxJumpLength) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpLength = maxJumpLength;
    }

    public static List<String> getActions(){
        return actions;
    }


}
