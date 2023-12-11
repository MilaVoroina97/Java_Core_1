package seminar.four.seminarTasks.taskThree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Rectangle implements Shape{

    private final int height;

    private final int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }


    @Override
    public void draw(Graphics graphics) {
        for(int row = 0; row < height; row++)
            graphics.drawHorizontalLine(width);
    }
}
