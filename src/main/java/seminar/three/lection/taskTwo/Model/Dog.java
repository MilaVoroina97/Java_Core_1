package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dog extends Animal{

    private final static List<Double> RANGE_RUN_LENGTH = List.of(500.0,625.0);
    private final static List<Double> RANGE_SWIM_LENGTH = List.of(100.0,125.0);
    private final static List<Double> RANGE_JUMP_HEIGHT = List.of(9.0,11.25);

    public Dog() {
        super(RANGE_RUN_LENGTH, RANGE_SWIM_LENGTH, RANGE_JUMP_HEIGHT);
    }


}
