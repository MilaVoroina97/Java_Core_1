package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bird extends Animal{

    private final static List<Double> MAX_RUN_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{15.0,18.75}));
    private final static List<Double> MAX_SWIM_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{5.0,6.25}));
    private final static List<Double> MAX_JUMP_HEIGHT = new ArrayList<>(Arrays.asList(new Double[]{600.0,750.0}));

    public Bird() {
        super(MAX_RUN_LENGTH, MAX_SWIM_LENGTH, MAX_JUMP_HEIGHT);
    }

    public static List<Double> getMaxJumpHeight() {
        return MAX_JUMP_HEIGHT;
    }
    public static List<Double> getMaxRunLength(){
        return MAX_RUN_LENGTH;
    }

    public static List<Double> getMaxSwimLength(){
        return MAX_SWIM_LENGTH;
    }


}
