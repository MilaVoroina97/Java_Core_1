package seminar.four.seminarTasks.taskThree;

import java.util.ArrayList;
import java.util.List;

public class Shapes {

    private final List<Shape> allShapes = new ArrayList<>();

    private final Graphics graphics;

    public Shapes(Graphics graphics) {
        this.graphics = graphics;
    }

    public void add(Shape shape){
        allShapes.add(shape);
    }

    public void draw(){
        for (Shape allShape : allShapes) {
            allShape.draw(graphics);
        }
    }


}
