package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bird extends Animal{

    private final static List<Double> RANGE_RUN_LENGTH = List.of(15.0,18.75);
    private final static List<Double> RANGE_SWIM_LENGTH = List.of(5.0,6.25);
    private final static List<Double> RANGE_JUMP_HEIGHT = List.of(600.0,750.0);

    public Bird() {
        super(RANGE_RUN_LENGTH, RANGE_SWIM_LENGTH, RANGE_JUMP_HEIGHT);
    }



}
