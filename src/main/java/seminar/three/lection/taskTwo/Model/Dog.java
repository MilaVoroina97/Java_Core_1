package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dog extends Animal{

    private final static List<Double> MAX_RUN_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{500.0,625.0}));
    private final static List<Double> MAX_SWIM_LENGTH = new ArrayList<>(Arrays.asList(new Double[]{100.0,125.0}));
    private final static List<Double> MAX_JUMP_HEIGHT = new ArrayList<>(Arrays.asList(new Double[]{9.0,11.25}));

    public Dog() {
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
