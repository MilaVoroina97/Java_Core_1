package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {

    private final List<Double> maxRunLength;
    private final List<Double> maxSwimLength;
    private final List<Double> maxJumpLength;

    public Animal(List<Double> maxRunLength, List<Double> maxSwimLength, List<Double> maxJumpLength) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpLength = maxJumpLength;
    }

    public abstract  boolean canRun(double length);
    public abstract boolean canSwim(double length);
    public abstract boolean canJump(double height);


}
