package seminar.three.lection.taskTwo.Viewer;

public interface View<T>{

    public double getUserInput() throws NumberFormatException;
    public void showMessage(String msg);
}
