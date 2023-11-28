package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Animal {

    private final List<Double> maxRunLength;
    private final List<Double> maxSwimLength;
    private final List<Double> maxJumpHeight;

    public Animal(List<Double> maxRunLength, List<Double> maxSwimLength, List<Double> maxJumpLength) {
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpLength;
    }

    public List<Double> getRangeJumpHeight() {
        return maxJumpHeight;
    }
    public List<Double> getRangeRunLength(){
        return maxRunLength;
    }

    public List<Double> getRangeSwimLength(){
        return maxSwimLength;
    }

    public boolean canRun(double length){return canDo(length,maxRunLength);}
    public boolean canSwim(double length){return canDo(length,maxSwimLength);}
    public boolean canJump(double height) {
        return canDo(height, maxJumpHeight);
    }

    private boolean canDo(double length, List<Double> range){
        return length > Collections.min(range) && length < Collections.max(range);
    }


}
