package seminar.three.lection.taskTwo.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cat extends Animal{

    private final static List<Double> RANGE_RUN_LENGTH = List.of(200.0,250.0);
    private final static List<Double> RANGE_SWIM_LENGTH = List.of(0.0);
    private final static List<Double> RANGE_JUMP_HEIGHT = List.of(10.0,12.5);

    public Cat() {
        super(RANGE_RUN_LENGTH, RANGE_SWIM_LENGTH, RANGE_JUMP_HEIGHT);
    }

    @Override
    public boolean canSwim(double length){
        System.out.println("This cat cannot swim. :(");
        return false;
    }
}
