package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bird extends Animal{

    private final static List<Double> RANGE_RUN_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{15.0,18.75}));
    private final static List<Double> RANGE_SWIM_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{5.0,6.25}));
    private final static List<Double> RANGE_JUMP_HEIGHT = new ArrayList<>(Arrays.asList(new Double[]{600.0,750.0}));

    public Bird() {
        super(RANGE_RUN_LENGTH, RANGE_SWIM_LENGTH, RANGE_JUMP_HEIGHT);
    }

    public static List<Double> getRangeJumpHeight() {
        return RANGE_JUMP_HEIGHT;
    }
    public static List<Double> getRangeRunLength(){
        return RANGE_RUN_LENGTH;
    }

    public static List<Double> getRangeSwimLength(){
        return RANGE_SWIM_LENGTH;
    }


    @Override
    public boolean canRun(double length) {
        return length > Collections.min(RANGE_RUN_LENGTH) && length < Collections.max(RANGE_RUN_LENGTH);
    }

    @Override
    public boolean canSwim(double length) {
        return length > Collections.min(RANGE_SWIM_LENGTH) && length < Collections.max(RANGE_SWIM_LENGTH);
    }

    @Override
    public boolean canJump(double height) {
        return height > Collections.min(RANGE_JUMP_HEIGHT) && height < Collections.max(RANGE_JUMP_HEIGHT);
    }

}
