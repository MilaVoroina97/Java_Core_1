package seminar.four.seminarTasks.taskThree;

public class ShapesDemo {
    public static void main(String[] args) {
        new ShapesDemo().run();
    }

    private void run(){
        Graphics console = new ConsoleGraphics();
        var shapes = new Shapes(console);
        shapes.add(new TextBox("Hello from the Shapes SOLID Demo"));
        shapes.add(new RightArrow());
        shapes.add(new Rectangle(5,2));
        shapes.add(new RightArrow());
        shapes.add(new TextBox("Using the SOLID principles to"));
        shapes.add(new RightArrow());
        shapes.add(new TextBox("create an extensible mini-framework."));
        shapes.add(new RightArrow());
        shapes.add(new TextBox("Draw shapes as ASCII art."));
        shapes.add(new RightArrow());
        shapes.add(new TextBox("Following is a 5 x 3 Rectangle:"));
        shapes.add(new RightArrow());
        shapes.add(new Rectangle(5,3));
        shapes.add(new RightArrow());

        shapes.draw();
    }
}
