package seminar.four.seminarTasks.taskThree;

public class TextBox implements Shape{

    private final String text;

    public TextBox(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawTest(text);
    }
}
