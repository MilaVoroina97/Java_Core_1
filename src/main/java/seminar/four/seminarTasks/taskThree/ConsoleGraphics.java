package seminar.four.seminarTasks.taskThree;

public class ConsoleGraphics implements Graphics{
    @Override
    public void drawTest(String text) {
        print(text);
    }

    @Override
    public void drawHorizontalLine(int width) {

        print("X".repeat(Math.max(0, width)));
    }

    private void print(String text){
        System.out.println(text);
    }
}
