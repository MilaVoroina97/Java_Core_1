package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cat extends Animal{

    private final static List<Double> RANGE_RUN_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{200.0,250.0}));
    private final static List<Double> RANGE_SWIM_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{0.0}));
    private final static List<Double> RANGE_JUMP_HEIGHT = new ArrayList<>(Arrays.asList(new Double[]{10.0,12.5}));

    public Cat() {
        super(RANGE_RUN_LENGTH, RANGE_SWIM_LENGTH, RANGE_JUMP_HEIGHT);
    }

//    public static List<Double> getMaxJumpHeight() {
//        return MAX_JUMP_HEIGHT;
//    }
//    public static List<Double> getMaxRunLength(){
//        return MAX_RUN_LENGTH;
//    }
//
//    public static List<Double> getMaxSwimLength(){
//        return MAX_SWIM_LENGTH;
//    }

    @Override
    public boolean canRun(double length) {
        return length > Collections.min(RANGE_RUN_LENGTH) && length < Collections.max(RANGE_RUN_LENGTH);
    }

    @Override
    public boolean canSwim(double length) {
        System.out.println("This cat cannot swim. :(");
        return false;
    }

    @Override
    public boolean canJump(double height) {
        return height > Collections.min(RANGE_JUMP_HEIGHT) && height < Collections.max(RANGE_JUMP_HEIGHT);
    }
}
